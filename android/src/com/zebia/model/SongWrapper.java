package com.zebia.model;

import com.google.android.gms.maps.model.LatLng;

public class SongWrapper {

    private Song song;

    public SongWrapper(Song song) {
        this.song = song;
    }

    public SongWrapper(int index) {
        this.song = SongStore.get(index);
    }

    public boolean hasLocation() {
        return song.getArtist_latitude() != null && song.getArtist_latitude() != 0.0
                && song.getArtist_longitude() != null && song.getArtist_longitude() != 0.0;
    }

    public LatLng getLatLng() {
        return new LatLng(song.getArtist_latitude(), song.getArtist_longitude());
    }

    public Song getSong() {
        return song;
    }
}
