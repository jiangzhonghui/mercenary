package com.zebia.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.zebia.R;
import com.zebia.model.Song;
import com.zebia.model.SongStore;

public class SongDetailsFragment extends Fragment {
    public static final String SONG_INDEX = "song-index";
    private int index;
    private Song song;

    public SongDetailsFragment() {
    }

//    public SongDetailsFragment(int index, Song song) {
//        this.index = index;
//        this.song = song;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        Bundle args = getArguments();
        index = args.getInt(SongDetailsFragment.SONG_INDEX, -1);

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

    public int getIndex() {
        return index;
    }

    public Song getSong() {
        return song;
    }

}
