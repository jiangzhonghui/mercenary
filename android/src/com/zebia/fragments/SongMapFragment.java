package com.zebia.fragments;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.zebia.SongActivity;
import com.zebia.SongDetailsActivity;
import com.zebia.model.SongStore;
import com.zebia.model.SongWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongMapFragment extends SupportMapFragment implements GoogleMap.OnInfoWindowClickListener {

    private Point size = new Point();
    private Map<Marker, Integer> markerSongMap = new HashMap<Marker, Integer>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        display.getSize(size);

        Bundle bundle = getActivity().getIntent().getExtras();
        if (bundle != null) {
            int songIndex = bundle.getInt(SongActivity.SONG_INDEX);

            if (songIndex == -1) {
                placeSongs(fetchAllSongsWithLocation());
            } else {
                List<SongWrapper> songs = new ArrayList<SongWrapper>();
                songs.add(new SongWrapper(songIndex));
                placeSongs(songs);
            }
        }

        getMap().setOnInfoWindowClickListener(this);

    }

    private void placeSongs(List<SongWrapper> songs) {
        LatLngBounds.Builder boundsBuilder = new LatLngBounds.Builder();
        for (SongWrapper songWrapper : songs) {
            addMarker(songWrapper);
            boundsBuilder.include(songWrapper.getLatLng());
        }

        CameraUpdate cameraUpdate;
        if (songs.size() == 1) {
            cameraUpdate = CameraUpdateFactory.newLatLngZoom(songs.get(0).getLatLng(), 10);
        } else {
            cameraUpdate = CameraUpdateFactory.newLatLngBounds(boundsBuilder.build(), size.x, size.y, 100);
        }
        getMap().moveCamera(cameraUpdate);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private List<SongWrapper> fetchAllSongsWithLocation() {
        List<SongWrapper> result = new ArrayList<SongWrapper>();
        for (int i = 0; i < SongStore.get().size(); i++) {
            SongWrapper songWrapper = new SongWrapper(i);
            if (songWrapper.hasLocation())
                result.add(songWrapper);
        }
        return result;
    }

    private void addMarker(SongWrapper songWrapper) {
        Marker marker = getMap().addMarker(
                new MarkerOptions().position(songWrapper.getLatLng())
                        .title(songWrapper.getSong().getArtist_name())
                        .snippet(songWrapper.getSong().getTitle()));
        markerSongMap.put(marker, songWrapper.getIndex());
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Integer songIndex = markerSongMap.get(marker);
        Intent launchSongDetailsIntent = new Intent().setClass(getActivity(), SongDetailsActivity.class);
        launchSongDetailsIntent.putExtra(SongActivity.SONG_INDEX, songIndex);
        startActivity(launchSongDetailsIntent);
    }

}
