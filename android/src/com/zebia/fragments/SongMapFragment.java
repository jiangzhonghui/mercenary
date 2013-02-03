package com.zebia.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.zebia.SongActivity;
import com.zebia.model.Song;
import com.zebia.model.SongStore;

public class SongMapFragment extends SupportMapFragment {
    private static final LatLng SYDNEY = new LatLng(-33.88, 151.21);
    private int songIndex;
    private Song song;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getActivity().getIntent().getExtras();
        if (bundle != null) {
            songIndex = bundle.getInt(SongActivity.SONG_INDEX);
            song = SongStore.get(songIndex);

            Float artist_latitude = song.getArtist_latitude();
            Float artist_longitude = song.getArtist_longitude();

            LatLng latLng = new LatLng(artist_latitude, artist_longitude);
            addMarker(latLng, song.getArtist_name(), song.getTitle());
            getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(artist_latitude, artist_longitude), 10));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void addMarker(LatLng latLng, String title, String infos) {
        Marker marker = getMap().addMarker(new MarkerOptions()
                .position(latLng).title(title).snippet(infos));
    }
}
