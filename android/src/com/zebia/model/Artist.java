package com.zebia.model;

import java.util.ArrayList;
import java.util.List;

public class Artist {

    //@SerializedName("from_user_name")
    private float artist_7digitalid;
    private float artist_familiarity;
    private float artist_hotttnesss;
    private String artist_id;
    private Float artist_latitude;
    private Float artist_longitude;
    private String artist_location;
    private String artist_mbid;
    private float artist_playmeid;
    private String artist_name;
    private ArrayList<String> artist_terms = new ArrayList<String>();
    private ArrayList<String> artist_tags = new ArrayList<String>();

    private ArrayList<String> similar_artists = new ArrayList<String>();

    public float getArtist_7digitalid() {
        return artist_7digitalid;
    }

    public float getArtist_familiarity() {
        return artist_familiarity;
    }

    public float getArtist_hotttnesss() {
        return artist_hotttnesss;
    }

    public String getArtist_id() {
        return artist_id;
    }

    public Float getArtist_latitude() {
        return artist_latitude;
    }

    public Float getArtist_longitude() {
        return artist_longitude;
    }

    public String getArtist_location() {
        return artist_location;
    }

    public String getArtist_mbid() {
        return artist_mbid;
    }

    public float getArtist_playmeid() {
        return artist_playmeid;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public ArrayList<String> getArtist_terms() {
        return artist_terms;
    }

    public ArrayList<String> getSimilar_artists() {
        return similar_artists;
    }

    public ArrayList<String> getArtist_tags() {
        return artist_tags;
    }
}
