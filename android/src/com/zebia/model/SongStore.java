package com.zebia.model;

import android.content.Context;
import com.google.gson.Gson;
import com.zebia.dao.SerialCashDao;
import com.zebia.dao.StorageItemsHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SongStore {
    private final static Gson gson = new Gson();
    private static SerialCashDao<SongsResponse> cashDao;

    private static List<Song> songs = new ArrayList<Song>();
    private static int lastLoadedPage = -1;
    private static int resultsPerPage = 15;

    public static void init(Context context) {
        cashDao = new SerialCashDao<SongsResponse>(new StorageItemsHelper(context, SongsResponse.class.getName()), SongsResponse.class);
    }

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

    public static String serialize() {
        SongsResponse serial = new SongsResponse();
        serial.setResults(songs);
        serial.setPage(lastLoadedPage);
        return gson.toJson(serial);
    }

    public static void deserialize(String json) {
        SongsResponse songsResponse = gson.fromJson(json, SongsResponse.class);
        songs = songsResponse.getResults();
        lastLoadedPage = songsResponse.getPage();
    }

    public static SongsResponse toSongResponse() {
        SongsResponse serial = new SongsResponse();
        serial.setResults(songs);
        serial.setPage(lastLoadedPage);
        return serial;
    }

    public static void fromSongsResponse(SongsResponse songsResponse, boolean append) {
        if (!append) {
            songs.clear();
        }
        songs.addAll(songsResponse.getResults());
        lastLoadedPage = songsResponse.getPage();
        resultsPerPage = songsResponse.getResultsPerPage();
    }

    public static int getLastLoadedPage() {
        return lastLoadedPage;
    }

    public static void setLastLoadedPage(int lastLoadedPage) {
        SongStore.lastLoadedPage = lastLoadedPage;
    }

    public static boolean isLastPage() {
        // TODO: not good
        return songs.size() == 0 || songs.size() % resultsPerPage != 0;
    }

    public static void persist() {
        if (cashDao == null) {
            throw new RuntimeException("Cache is not initialised");
        }
        cashDao.save(toSongResponse());
    }

    public static void restore() {
        if (cashDao == null) {
            throw new RuntimeException("Cache is not initialised");
        }

        SongsResponse songsResponse = cashDao.restore();
        if (songsResponse != null) {
            SongStore.fromSongsResponse(songsResponse, false);
        }
    }
}
