package com.zebia.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SongStore {

    private static List<Song> songs = new ArrayList<Song>();

    public static List<Song> get() {
        return songs;
    }

    public static void add(Song song) {
        songs.add(song);
    }

    public static void addAll(Collection<? extends Song> songCollection) {
        songs.addAll(songCollection);
    }

    public static void clear() {
        songs.clear();
    }

    public static void remove(Song song) {
        SongStore.remove(song);
    }

    public static Song get(int songIndex) {
        return songs.get(songIndex);
    }
}
