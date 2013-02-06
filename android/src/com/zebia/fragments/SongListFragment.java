package com.zebia.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zebia.*;
import com.zebia.adapter.SongArrayAdapter;
import com.zebia.loaders.SerialLoader;
import com.zebia.loaders.params.ParamsMapper;
import com.zebia.loaders.params.RestParamBuilder;
import com.zebia.loaders.params.SearchParams;
import com.zebia.loaders.params.SongsParamsMapper;
import com.zebia.model.Artist;
import com.zebia.model.Response;
import com.zebia.model.SongStore;
import com.zebia.model.SongsResponse;
import com.zebia.utils.Animations;

public class SongListFragment extends Fragment implements
        AdapterView.OnItemClickListener,
        LoaderManager.LoaderCallbacks<SerialLoader.RestResponse<Response>>,
        SearchView.OnQueryTextListener,
        PullToRefreshBase.OnRefreshListener<ListView> {

    private static final String LOG_TAG = SongListFragment.class.getName();
    private static final int LOADER_SONGS_SEARCH = 0x2;
    private static final int REQUEST_CODE_PREFERENCES = 1;

    private static final String SEARCH_QUERY = "CURRENT_PAGE";

    private SongArrayAdapter songsAdapter;
    private SearchView searchView;
    private String searchQuery = null;
    private OnItemSelectedListener onItemSelectedListener;
    private PullToRefreshListView pullToRefreshListView;

    private ParamsMapper paramsMapper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.paramsMapper = new SongsParamsMapper();

        if (savedInstanceState != null) {
            searchQuery = savedInstanceState.getString(SEARCH_QUERY);
        }

        getActivity().getActionBar().setDisplayShowTitleEnabled(false);
        getActivity().getActionBar().setHomeButtonEnabled(false);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(false);

        pullToRefreshListView = (PullToRefreshListView) getView().findViewById(R.id.song_list);
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.DISABLED);
        pullToRefreshListView.setOnRefreshListener(this);

        songsAdapter = new SongArrayAdapter(getActivity());

        ListView listView = pullToRefreshListView.getRefreshableView();
        listView.setAdapter(songsAdapter);
        listView.setLayoutAnimation(Animations.listAnimation());
        listView.setOnItemClickListener(this);

        // Cache initialisation
        SongStore.init(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.song_fragment, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.action_bar_song_settings_action_provider, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search_song).getActionView();
        searchView.setQueryHint("Song title");
        searchView.setOnQueryTextListener(this);

        if (searchQuery != null) {
            searchView.setQuery(searchQuery, false);
        }

        this.searchView = searchView;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        // menu.findItem(R.id.menu_clear_list).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onItemSelectedListener = (OnItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnItemSelectedListener");
        }
    }

    // ---------------------------------------------------------------------------------------------------
    // -- SAVE & RESTORE ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------------

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(SEARCH_QUERY, searchQuery);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();

//        if (SongStore.get().size() == 0) {
//            SongStore.restore();
//        }
        updateViewFromStore();
    }

    @Override
    public void onPause() {
        super.onPause();
        SongStore.persist();
    }

    // ---------------------------------------------------------------------------------------------------
    // -- ACTION BAR -------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------------

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_map_songs:
                Intent intent = new Intent().setClass(getActivity(), SongMapActivity.class);
                intent.putExtra(SongActivity.SONG_INDEX, -1); // All locations
                startActivity(intent);

            case R.id.menu_logout_song:
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor prefEditor = sharedPreferences.edit();
                prefEditor.putString(LoginActivity.USER_MAIL_LOGIN, "NONE-");
                prefEditor.commit();


                break;
            case R.id.menu_preferences_song:
                Intent launchPreferencesIntent = new Intent().setClass(getActivity(), SettingsActivity.class);
                startActivityForResult(launchPreferencesIntent, REQUEST_CODE_PREFERENCES);
                break;
        }

        return true;
    }

    // ---------------------------------------------------------------------------------------------------
    // -- On item selected -------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------------

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        onItemSelectedListener.onItemSelected(position - 1);
    }

    // ---------------------------------------------------------------------------------------------------
    // -- Loaders ----------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------------

    @Override
    public Loader<SerialLoader.RestResponse<Response>> onCreateLoader(int id, Bundle args) {
        Log.d(LOG_TAG, "Begin onCreateLoader()");

        if (args != null && args.containsKey(RestParamBuilder.ARGS_URI)) {
            Uri action = args.getParcelable(RestParamBuilder.ARGS_URI);
            Bundle params = args.getParcelable(RestParamBuilder.ARGS_PARAMS);
            Boolean reload = args.getBoolean(RestParamBuilder.ARGS_RELOAD);

            return new SerialLoader(getActivity(), SerialLoader.HTTPVerb.GET, action, params, reload, Response.class);
        }

        return null;
    }


    @Override
    public void onLoadFinished(Loader<SerialLoader.RestResponse<Response>> loader, SerialLoader.RestResponse<Response> data) {
        pullToRefreshListView.onRefreshComplete();
        getActivity().setProgressBarIndeterminateVisibility(false);

        int code = data.getCode();
        if (code == 200) {
            SongStore.fromSongsResponse(data.getData(), data.getData().getPage() != 0);
            updateViewFromStore();
            //Toast.makeText(getActivity(), "Loaded page: " + SongStore.getLastLoadedPage(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Failed to load data. Check your internet settings.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void updateViewFromStore() {
        songsAdapter.clear();
        songsAdapter.addAll(SongStore.get());

        if (SongStore.isLastPage()) {
            pullToRefreshListView.setMode(PullToRefreshBase.Mode.DISABLED);
        } else {
            pullToRefreshListView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        }
    }

    @Override
    public void onLoaderReset(Loader<SerialLoader.RestResponse<Response>> loader) {
        Log.d(LOG_TAG, "Begin onLoaderReset()");
    }

    // ---------------------------------------------------------------------------------------------------
    // -- Search -----------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------------
    @Override
    public boolean onQueryTextSubmit(String query) {
        searchView.setQuery("", false);
        searchView.setIconified(true);

        searchView.setQuery(query, false);

        this.searchQuery = query;
        SongStore.setLastLoadedPage(-1);

        getActivity().setProgressBarIndeterminateVisibility(true);

        Bundle params = new RestParamBuilder(getActivity(), paramsMapper)
                .putParam(SearchParams.ARTIST_NAME, searchQuery).build();

        getLoaderManager().restartLoader(LOADER_SONGS_SEARCH, params, this);

        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    // Fragment / Activity communication
    public interface OnItemSelectedListener {
        public void onItemSelected(int index);
    }

    // ---------------------------------------------------------------------------------------------------
    // -- Pull TO REFRESH --------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------------

    @Override
    public void onRefresh(PullToRefreshBase<ListView> refreshView) {
        String label = DateUtils.formatDateTime(getActivity().getApplicationContext(), System.currentTimeMillis(),
                DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

        refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);

        if (refreshView.getCurrentMode() == PullToRefreshBase.Mode.PULL_FROM_END) {
            loadNextPage();
        } else {
            synchronization();
        }
    }

    private void loadNextPage() {
        Bundle params = new RestParamBuilder(getActivity(), paramsMapper)
                .putParam(SearchParams.ARTIST_NAME, searchQuery)
                .putParam(SearchParams.PAGE, SongStore.getLastLoadedPage() + 1).build();
        getLoaderManager().restartLoader(LOADER_SONGS_SEARCH, params, this);
    }

    // ---------------------------------------------------------------------------------------------------
    // -- SYNC -------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------------

    private void synchronization() {
        Bundle params = new RestParamBuilder(getActivity(), paramsMapper)
                .putParam(SearchParams.ARTIST_NAME, searchQuery).build();
        getLoaderManager().restartLoader(LOADER_SONGS_SEARCH, params, this);
    }
}