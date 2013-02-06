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
    private static SerialCashDao<Response> cashDao;

    private static List<Artist> artists = new ArrayList<Artist>();
    private static int lastLoadedPage = -1;
    private static int resultsPerPage = 15;

    public static void init(Context context) {
        cashDao = new SerialCashDao<Response>(new StorageItemsHelper(context, Response.class.getName()), Response.class);
    }

    public static List<Artist> get() {
        return artists;
    }

    public static void add(Artist song) {
        artists.add(song);
    }

    public static void addAll(Collection<? extends Artist> songCollection) {
        artists.addAll(songCollection);
    }

    public static void clear() {
        artists.clear();
    }

    public static void remove(Artist song) {
        SongStore.remove(song);
    }

    public static Artist get(int songIndex) {
        return artists.get(songIndex);
    }

    public static String serialize() {
        Response serial = new Response();
        serial.setResults(artists);
        serial.setPage(lastLoadedPage);
        return gson.toJson(serial);
    }

    public static void deserialize(String json) {
        Response songsResponse = gson.fromJson(json, Response.class);
        artists = songsResponse.getResults();
        lastLoadedPage = songsResponse.getPage();
    }

    public static Response toSongResponse() {
        Response serial = new Response();
        serial.setResults(artists);
        serial.setPage(lastLoadedPage);
        return serial;
    }

    public static void fromSongsResponse(Response songsResponse, boolean append) {
        if (!append) {
            artists.clear();
        }
        artists.addAll(songsResponse.getResults());
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
        return artists.size() == 0 || artists.size() % resultsPerPage != 0;
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

        Response songsResponse = cashDao.restore();
        if (songsResponse != null) {
            SongStore.fromSongsResponse(songsResponse, false);
        }
    }
}
