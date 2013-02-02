package com.zebia.model;

public class Song {

    //@SerializedName("from_user_name")
    private float artist_7digitalid;
    private float artist_familiarity;
    private float artist_hotttnesss;
    private float analysis_sample_rate;
    private String artist_id;
    private float artist_latitude;
    private float artist_longitude;
    private String artist_location;
    private String artist_mbid;
    private float artist_playmeid;
    private String artist_name;
    private String release;
    private int release_7digitalid;
    private float song_hotttnesss;
    private String song_id;
    private String title;
    private int track_7digitalid;
    private int nSongs;
    private float duration;
    private float danceability;
    private float end_of_fade_in;
    private float energy;
    private float key;
    private float key_confidence;
    private float loudness;
    private float mode;
    private float mode_confidence;
    private float start_of_fade_out;
    private float tempo;
    private float time_signature;
    private float time_signature_confidence;
    private int year;
    private String _id;

    public Song() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public float getAnalysis_sample_rate() {
        return analysis_sample_rate;
    }

    public void setAnalysis_sample_rate(float analysis_sample_rate) {
        this.analysis_sample_rate = analysis_sample_rate;
    }

    public float getArtist_7digitalid() {
        return artist_7digitalid;
    }

    public void setArtist_7digitalid(float artist_7digitalid) {
        this.artist_7digitalid = artist_7digitalid;
    }

    public float getArtist_familiarity() {
        return artist_familiarity;
    }

    public void setArtist_familiarity(float artist_familiarity) {
        this.artist_familiarity = artist_familiarity;
    }

    public float getArtist_hotttnesss() {
        return artist_hotttnesss;
    }

    public void setArtist_hotttnesss(float artist_hotttnesss) {
        this.artist_hotttnesss = artist_hotttnesss;
    }

    public String getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(String artist_id) {
        this.artist_id = artist_id;
    }

    public float getArtist_latitude() {
        return artist_latitude;
    }

    public void setArtist_latitude(float artist_latitude) {
        this.artist_latitude = artist_latitude;
    }

    public String getArtist_location() {
        return artist_location;
    }

    public void setArtist_location(String artist_location) {
        this.artist_location = artist_location;
    }

    public float getArtist_longitude() {
        return artist_longitude;
    }

    public void setArtist_longitude(float artist_longitude) {
        this.artist_longitude = artist_longitude;
    }

    public String getArtist_mbid() {
        return artist_mbid;
    }

    public void setArtist_mbid(String artist_mbid) {
        this.artist_mbid = artist_mbid;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public float getArtist_playmeid() {
        return artist_playmeid;
    }

    public void setArtist_playmeid(float artist_playmeid) {
        this.artist_playmeid = artist_playmeid;
    }

    public float getDanceability() {
        return danceability;
    }

    public void setDanceability(float danceability) {
        this.danceability = danceability;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public float getEnd_of_fade_in() {
        return end_of_fade_in;
    }

    public void setEnd_of_fade_in(float end_of_fade_in) {
        this.end_of_fade_in = end_of_fade_in;
    }

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public float getKey() {
        return key;
    }

    public void setKey(float key) {
        this.key = key;
    }

    public float getKey_confidence() {
        return key_confidence;
    }

    public void setKey_confidence(float key_confidence) {
        this.key_confidence = key_confidence;
    }

    public float getLoudness() {
        return loudness;
    }

    public void setLoudness(float loudness) {
        this.loudness = loudness;
    }

    public float getMode() {
        return mode;
    }

    public void setMode(float mode) {
        this.mode = mode;
    }

    public float getMode_confidence() {
        return mode_confidence;
    }

    public void setMode_confidence(float mode_confidence) {
        this.mode_confidence = mode_confidence;
    }

    public int getnSongs() {
        return nSongs;
    }

    public void setnSongs(int nSongs) {
        this.nSongs = nSongs;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public int getRelease_7digitalid() {
        return release_7digitalid;
    }

    public void setRelease_7digitalid(int release_7digitalid) {
        this.release_7digitalid = release_7digitalid;
    }

    public float getSong_hotttnesss() {
        return song_hotttnesss;
    }

    public void setSong_hotttnesss(float song_hotttnesss) {
        this.song_hotttnesss = song_hotttnesss;
    }

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public float getStart_of_fade_out() {
        return start_of_fade_out;
    }

    public void setStart_of_fade_out(float start_of_fade_out) {
        this.start_of_fade_out = start_of_fade_out;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public float getTime_signature() {
        return time_signature;
    }

    public void setTime_signature(float time_signature) {
        this.time_signature = time_signature;
    }

    public float getTime_signature_confidence() {
        return time_signature_confidence;
    }

    public void setTime_signature_confidence(float time_signature_confidence) {
        this.time_signature_confidence = time_signature_confidence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTrack_7digitalid() {
        return track_7digitalid;
    }

    public void setTrack_7digitalid(int track_7digitalid) {
        this.track_7digitalid = track_7digitalid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
