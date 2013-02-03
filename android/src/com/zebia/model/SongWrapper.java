package com.zebia.model;

import com.google.android.gms.maps.model.LatLng;

public class SongWrapper {

    private Song song;
    private int index = -1;

    public SongWrapper(Song song) {
        this.song = song;
    }

    public SongWrapper(int index) {
        this.song = SongStore.get(index);
        this.index = index;
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

    public int getIndex() {
        return index;
    }
}
