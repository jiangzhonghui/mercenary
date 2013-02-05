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
import com.zebia.model.Song;
import com.zebia.model.SongStore;
import com.zebia.utils.Geocoding;

public class SongDetailsFragment extends Fragment {
    private int index;
    private Song song;

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
            TextView txRelease = (TextView) getView().findViewById(R.id.tx_detail_song_release);
            TextView txTitle = (TextView) getView().findViewById(R.id.tx_detail_song_title);
            TextView txYear = (TextView) getView().findViewById(R.id.tx_detail_song_year);

            txArtist.setText(song.getArtist_name());
            txRelease.setText(song.getRelease());
            txTitle.setText(song.getTitle());
            txYear.setText(String.valueOf(song.getYear()));
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.action_bar_song_details, menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        if(!hasLocation() && song.getArtist_location() != null){
            //try to geocode address
            LatLng latLng = Geocoding.reverseGeocoding(getActivity().getApplicationContext(), song.getArtist_location());
            if(latLng != null){
                song.setArtist_latitude((float)latLng.latitude);
                song.setArtist_longitude((float)latLng.longitude);
            }
        }

        menu.findItem(R.id.menu_song_details_map).setVisible(hasLocation());
        super.onPrepareOptionsMenu(menu);
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

    public Song getSong() {
        return song;
    }

    private boolean hasLocation() {
        return song.getArtist_latitude() != null && song.getArtist_latitude() != 0.0
                && song.getArtist_longitude() != null && song.getArtist_longitude() != 0.0;
    }

}
