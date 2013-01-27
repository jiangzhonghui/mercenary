package com.jeaneudes.xebia.xke.fevrier;

public class Song {

    private int artist_7digitalid;
    private double artist_familiarity;
    private double artist_hotttnesss;
    private double analysis_sample_rate;
    private String artist_id;
    private double artist_latitude;
    private double artist_longitude;
    private String artist_location;
    private String artist_mbid;
    private int artist_playmeid;
    private String artist_name;
    private String release;
    private int release_7digitalid;
    private double song_hotttnesss;
    private String song_id;
    private String title;
    private int track_7digitalid;
    private int nSongs;
    private String[] artist_mbtags;
    private int[] artist_mbtags_count;
    private String[] artist_terms;
    private double[] artist_terms_freq;
    private double[] artist_terms_weight;
    private String audio_md5;
    private String[] similar_artists;
    private double duration;
    private double danceability;
    private double end_of_fade_in;
    private double energy;
    private double key;
    private double key_confidence;
    private double loudness;
    private double mode;
    private double mode_confidence;
    private double start_of_fade_out;
    private double tempo;
    private double time_signature;
    private double time_signature_confidence;
    private String track_id;

    private double[] segments_start;
    private double[] segments_timbre;
    private double[] segments_confidence;
    private double[] segments_pitches;
    private double[] segments_loudness_max;
    private double[] segments_loudness_max_time;
    private double[] segments_loudness_max_start;

    private double[] sections_start;
    private double[] sections_confidence;

    private double[] beats_start;
    private double[] beats_confidence;

    private double[] bars_start;
    private double[] bars_confidence;

    private double[] tatums_start;
    private double[] tatums_confidence;

    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double[] getTatums_start() {
        return tatums_start;
    }

    public void setTatums_start(double[] tatums_start) {
        this.tatums_start = tatums_start;
    }

    public double[] getSegments_start() {
        return segments_start;
    }

    public void setSegments_start(double[] segments_start) {
        this.segments_start = segments_start;
    }

    public double[] getSegments_timbre() {
        return segments_timbre;
    }

    public void setSegments_timbre(double[] segments_timbre) {
        this.segments_timbre = segments_timbre;
    }

    public double[] getSegments_confidence() {
        return segments_confidence;
    }

    public void setSegments_confidence(double[] segments_confidence) {
        this.segments_confidence = segments_confidence;
    }

    public double[] getSegments_pitches() {
        return segments_pitches;
    }

    public void setSegments_pitches(double[] segments_pitches) {
        this.segments_pitches = segments_pitches;
    }

    public double[] getSegments_loudness_max() {
        return segments_loudness_max;
    }

    public void setSegments_loudness_max(double[] segments_loudness_max) {
        this.segments_loudness_max = segments_loudness_max;
    }

    public double[] getSegments_loudness_max_time() {
        return segments_loudness_max_time;
    }

    public void setSegments_loudness_max_time(double[] segments_loudness_max_time) {
        this.segments_loudness_max_time = segments_loudness_max_time;
    }

    public double[] getSegments_loudness_max_start() {
        return segments_loudness_max_start;
    }

    public void setSegments_loudness_max_start(double[] segments_loudness_max_start) {
        this.segments_loudness_max_start = segments_loudness_max_start;
    }

    public double[] getSections_start() {
        return sections_start;
    }

    public void setSections_start(double[] sections_start) {
        this.sections_start = sections_start;
    }

    public double[] getSections_confidence() {
        return sections_confidence;
    }

    public void setSections_confidence(double[] sections_confidence) {
        this.sections_confidence = sections_confidence;
    }

    public double[] getBeats_start() {
        return beats_start;
    }

    public void setBeats_start(double[] beats_start) {
        this.beats_start = beats_start;
    }

    public double[] getBeats_confidence() {
        return beats_confidence;
    }

    public void setBeats_confidence(double[] beats_confidence) {
        this.beats_confidence = beats_confidence;
    }

    public double[] getBars_start() {
        return bars_start;
    }

    public void setBars_start(double[] bars_start) {
        this.bars_start = bars_start;
    }

    public double[] getBars_confidence() {
        return bars_confidence;
    }

    public void setBars_confidence(double[] bars_confidence) {
        this.bars_confidence = bars_confidence;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public double getTime_signature() {
        return time_signature;
    }

    public void setTime_signature(double time_signature) {
        this.time_signature = time_signature;
    }

    public double getTime_signature_confidence() {
        return time_signature_confidence;
    }

    public void setTime_signature_confidence(double time_signature_confidence) {
        this.time_signature_confidence = time_signature_confidence;
    }

    public String getTrack_id() {
        return track_id;
    }

    public void setTrack_id(String track_id) {
        this.track_id = track_id;
    }

    public double getStart_of_fade_out() {
        return start_of_fade_out;
    }

    public void setStart_of_fade_out(double start_of_fade_out) {
        this.start_of_fade_out = start_of_fade_out;
    }

    public double[] getTatums_confidence() {
        return tatums_confidence;
    }

    public void setTatums_confidence(double[] tatums_confidence) {
        this.tatums_confidence = tatums_confidence;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDanceability() {
        return danceability;
    }

    public void setDanceability(double danceability) {
        this.danceability = danceability;
    }

    public double getEnd_of_fade_in() {
        return end_of_fade_in;
    }

    public void setEnd_of_fade_in(double end_of_fade_in) {
        this.end_of_fade_in = end_of_fade_in;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getKey() {
        return key;
    }

    public void setKey(double key) {
        this.key = key;
    }

    public double getKey_confidence() {
        return key_confidence;
    }

    public void setKey_confidence(double key_confidence) {
        this.key_confidence = key_confidence;
    }

    public double getLoudness() {
        return loudness;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    public double getMode() {
        return mode;
    }

    public void setMode(double mode) {
        this.mode = mode;
    }

    public double getMode_confidence() {
        return mode_confidence;
    }

    public void setMode_confidence(double mode_confidence) {
        this.mode_confidence = mode_confidence;
    }

    public String[] getArtist_mbtags() {
        return artist_mbtags;
    }

    public void setArtist_mbtags(String[] artist_mbtags) {
        this.artist_mbtags = artist_mbtags;
    }

    public int[] getArtist_mbtags_count() {
        return artist_mbtags_count;
    }

    public void setArtist_mbtags_count(int[] artist_mbtags_count) {
        this.artist_mbtags_count = artist_mbtags_count;
    }

    public String[] getArtist_terms() {
        return artist_terms;
    }

    public void setArtist_terms(String[] artist_terms) {
        this.artist_terms = artist_terms;
    }

    public double[] getArtist_terms_freq() {
        return artist_terms_freq;
    }

    public void setArtist_terms_freq(double[] artist_terms_freq) {
        this.artist_terms_freq = artist_terms_freq;
    }

    public double[] getArtist_terms_weight() {
        return artist_terms_weight;
    }

    public void setArtist_terms_weight(double[] artist_terms_weight) {
        this.artist_terms_weight = artist_terms_weight;
    }

    public String getAudio_md5() {
        return audio_md5;
    }

    public void setAudio_md5(String audio_md5) {
        this.audio_md5 = audio_md5;
    }

    public String[] getSimilar_artists() {
        return similar_artists;
    }

    public void setSimilar_artists(String[] similar_artists) {
        this.similar_artists = similar_artists;
    }

    public int getnSongs() {
        return nSongs;
    }

    public void setnSongs(int nSongs) {
        this.nSongs = nSongs;
    }

    public int getTrack_7digitalid() {
        return track_7digitalid;
    }

    public void setTrack_7digitalid(int track_7digitalid) {
        this.track_7digitalid = track_7digitalid;
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

    public double getSong_hotttnesss() {
        return song_hotttnesss;
    }

    public void setSong_hotttnesss(double song_hotttnesss) {
        this.song_hotttnesss = song_hotttnesss;
    }

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist_mbid() {
        return artist_mbid;
    }

    public void setArtist_mbid(String artist_mbid) {
        this.artist_mbid = artist_mbid;
    }

    public int getArtist_playmeid() {
        return artist_playmeid;
    }

    public void setArtist_playmeid(int artist_playmeid) {
        this.artist_playmeid = artist_playmeid;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public int getArtist_7digitalid() {
        return artist_7digitalid;
    }

    public void setArtist_7digitalid(int artist_7digitalid) {
        this.artist_7digitalid = artist_7digitalid;
    }

    public double getArtist_familiarity() {
        return artist_familiarity;
    }

    public void setArtist_familiarity(double artist_familiarity) {
        this.artist_familiarity = artist_familiarity;
    }

    public double getArtist_hotttnesss() {
        return artist_hotttnesss;
    }

    public void setArtist_hotttnesss(double artist_hotttnesss) {
        this.artist_hotttnesss = artist_hotttnesss;
    }

    public double getAnalysis_sample_rate() {
        return analysis_sample_rate;
    }

    public void setAnalysis_sample_rate(double analysis_sample_rate) {
        this.analysis_sample_rate = analysis_sample_rate;
    }

    public String getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(String artist_id) {
        this.artist_id = artist_id;
    }

    public double getArtist_latitude() {
        return artist_latitude;
    }

    public void setArtist_latitude(double artist_latitude) {
        this.artist_latitude = artist_latitude;
    }

    public double getArtist_longitude() {
        return artist_longitude;
    }

    public void setArtist_longitude(double artist_longitude) {
        this.artist_longitude = artist_longitude;
    }

    public String getArtist_location() {
        return artist_location;
    }

    public void setArtist_location(String artist_location) {
        this.artist_location = artist_location;
    }
}
