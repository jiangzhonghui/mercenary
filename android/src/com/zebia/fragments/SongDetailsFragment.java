package com.zebia.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.*;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.maps.model.LatLng;
import com.zebia.R;
import com.zebia.SongActivity;
import com.zebia.SongMapActivity;
import com.zebia.model.Artist;
import com.zebia.model.Song;
import com.zebia.model.SongStore;
import com.zebia.model.SongWrapper;
import com.zebia.utils.Geocoding;

public class SongDetailsFragment extends Fragment {
    private int index;
    private Artist song;

    public SongDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        Bundle args = getArguments();
        index = args.getInt(SongActivity.SONG_INDEX, -1);

        if (index != -1) {
            song = SongStore.get(index);
            return inflater.inflate(R.layout.song_detail, container, false);
        } else {
            ScrollView scroller = new ScrollView(getActivity());
            TextView text = new TextView(getActivity());
            int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    4, getActivity().getResources().getDisplayMetrics());
            text.setPadding(padding, padding, padding, padding);
            scroller.addView(text);
            text.setText("Chose a song...");
            return scroller;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (song != null) {
            TextView txArtist = (TextView) getView().findViewById(R.id.tx_detail_song_artist);
            TextView txTerms = (TextView) getView().findViewById(R.id.tx_detail_song_year);

            StringBuilder stringBuilder = new StringBuilder();
            for(String tag : song.getArtist_terms()){
                stringBuilder.append(tag).append(",");

            }
            txTerms.setText(stringBuilder.toString());
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.action_bar_song_details, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_song_details_map:
                Intent intent = new Intent().setClass(getActivity(), SongMapActivity.class);
                intent.putExtra(SongActivity.SONG_INDEX, index);
                startActivity(intent);
                break;
        }

        return true;
    }

    public int getIndex() {
        return index;
    }

    public Artist getSong() {
        return song;
    }

}
