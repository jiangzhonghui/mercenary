package com.jeaneudes.xebia.xke.fevrier;


import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import ncsa.hdf.hdf5lib.exceptions.HDF5Exception;
import ncsa.hdf.object.h5.H5CompoundDS;
import ncsa.hdf.object.h5.H5File;
import ncsa.hdf.object.h5.H5ScalarDS;
import org.elasticsearch.action.index.IndexResponse;
import static org.elasticsearch.common.xcontent.XContentFactory.*;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * Class containing static methods to open a HDF5 song file and access its content.
 */
public class hdf5_getters {

    static MongoCollection songs;
    static Client client;

    static {
        DB db = null;
        try {
            db = new Mongo().getDB("mercenary");
        } catch (UnknownHostException e) {


        }

        Jongo jongo = new Jongo(db);
        songs = jongo.getCollection("song");
        Node node = nodeBuilder().node();
        client = node.client();

    }

    /**
     * Opens an existing HDF5 file with read only access.
     */
    public static H5File hdf5_open_readonly(String filename) {
        return new H5File(filename, H5File.READ);
    }

    /**
     * Closes the HDF5 file.
     * Function usefull only because of the try/catch
     */
    public static void hdf5_close(H5File h5) {
        try {
            h5.close();
        } catch (HDF5Exception ex) {
            System.out.println("Could not close HDF5 file?");
            ex.printStackTrace();
        }
    }

    public static int get_num_songs(H5File h5) {
        H5CompoundDS metadata;
        try {
            metadata = (H5CompoundDS) h5.get("/metadata/songs");
            metadata.init();
            return metadata.getHeight();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static double get_artist_familiarity(H5File h5) throws Exception {
        return get_artist_familiarity(h5, 0);
    }

    public static double get_artist_familiarity(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/metadata/songs", "artist_familiarity");
    }

    public static double get_artist_hotttnesss(H5File h5) throws Exception {
        return get_artist_hotttnesss(h5, 0);
    }

    public static double get_artist_hotttnesss(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/metadata/songs", "artist_hotttnesss");
    }

    public static String get_artist_id(H5File h5) throws Exception {
        return get_artist_id(h5, 0);
    }

    public static String get_artist_id(H5File h5, int songidx) throws Exception {
        return get_member_string(h5, songidx, "/metadata/songs", "artist_id");
    }

    public static String get_artist_mbid(H5File h5) throws Exception {
        return get_artist_mbid(h5, 0);
    }

    public static String get_artist_mbid(H5File h5, int songidx) throws Exception {
        return get_member_string(h5, songidx, "/metadata/songs", "artist_mbid");
    }

    public static int get_artist_playmeid(H5File h5) throws Exception {
        return get_artist_playmeid(h5, 0);
    }

    public static int get_artist_playmeid(H5File h5, int songidx) throws Exception {
        return get_member_int(h5, songidx, "/metadata/songs", "artist_playmeid");
    }

    public static int get_artist_7digitalid(H5File h5) throws Exception {
        return get_artist_7digitalid(h5, 0);
    }

    public static int get_artist_7digitalid(H5File h5, int songidx) throws Exception {
        return get_member_int(h5, songidx, "/metadata/songs", "artist_7digitalid");
    }

    public static double get_artist_latitude(H5File h5) throws Exception {
        return get_artist_latitude(h5, 0);
    }

    public static double get_artist_latitude(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/metadata/songs", "artist_latitude");
    }

    public static double get_artist_longitude(H5File h5) throws Exception {
        return get_artist_longitude(h5, 0);
    }

    public static double get_artist_longitude(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/metadata/songs", "artist_longitude");
    }

    public static String get_artist_location(H5File h5) throws Exception {
        return get_artist_location(h5, 0);
    }

    public static String get_artist_location(H5File h5, int songidx) throws Exception {
        return get_member_string(h5, songidx, "/metadata/songs", "artist_location");
    }

    public static String get_artist_name(H5File h5) throws Exception {
        return get_artist_name(h5, 0);
    }

    public static String get_artist_name(H5File h5, int songidx) throws Exception {
        return get_member_string(h5, songidx, "/metadata/songs", "artist_name");
    }

    public static String get_release(H5File h5) throws Exception {
        return get_release(h5, 0);
    }

    public static String get_release(H5File h5, int songidx) throws Exception {
        return get_member_string(h5, songidx, "/metadata/songs", "release");
    }

    public static int get_release_7digitalid(H5File h5) throws Exception {
        return get_release_7digitalid(h5, 0);
    }

    public static int get_release_7digitalid(H5File h5, int songidx) throws Exception {
        return get_member_int(h5, songidx, "/metadata/songs", "release_7digitalid");
    }

    public static String get_song_id(H5File h5) throws Exception {
        return get_song_id(h5, 0);
    }

    public static String get_song_id(H5File h5, int songidx) throws Exception {
        return get_member_string(h5, songidx, "/metadata/songs", "song_id");
    }

    public static double get_song_hotttnesss(H5File h5) throws Exception {
        return get_song_hotttnesss(h5, 0);
    }

    public static double get_song_hotttnesss(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/metadata/songs", "song_hotttnesss");
    }

    public static String get_title(H5File h5) throws Exception {
        return get_title(h5, 0);
    }

    public static String get_title(H5File h5, int songidx) throws Exception {
        return get_member_string(h5, songidx, "/metadata/songs", "title");
    }

    public static int get_track_7digitalid(H5File h5) throws Exception {
        return get_track_7digitalid(h5, 0);
    }

    public static int get_track_7digitalid(H5File h5, int songidx) throws Exception {
        return get_member_int(h5, songidx, "/metadata/songs", "track_7digitalid");
    }

    public static String[] get_similar_artists(H5File h5) throws Exception {
        return get_similar_artists(h5, 0);
    }

    public static String[] get_similar_artists(H5File h5, int songidx) throws Exception {
        return get_array_string(h5, songidx, "metadata", "similar_artists");
    }

    public static String[] get_artist_terms(H5File h5) throws Exception {
        return get_artist_terms(h5, 0);
    }

    public static String[] get_artist_terms(H5File h5, int songidx) throws Exception {
        return get_array_string(h5, songidx, "metadata", "artist_terms");
    }

    public static double[] get_artist_terms_freq(H5File h5) throws Exception {
        return get_artist_terms_freq(h5, 0);
    }

    public static double[] get_artist_terms_freq(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "metadata", "artist_terms_freq", 1, "idx_artist_terms");
    }

    public static double[] get_artist_terms_weight(H5File h5) throws Exception {
        return get_artist_terms_weight(h5, 0);
    }

    public static double[] get_artist_terms_weight(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "metadata", "artist_terms_weight", 1, "idx_artist_terms");
    }

    public static double get_analysis_sample_rate(H5File h5) throws Exception {
        return get_analysis_sample_rate(h5, 0);
    }

    public static double get_analysis_sample_rate(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/analysis/songs", "analysis_sample_rate");
    }

    public static String get_audio_md5(H5File h5) throws Exception {
        return get_audio_md5(h5, 0);
    }

    public static String get_audio_md5(H5File h5, int songidx) throws Exception {
        return get_member_string(h5, songidx, "/analysis/songs", "audio_md5");
    }

    public static double get_danceability(H5File h5) throws Exception {
        return get_danceability(h5, 0);
    }

    public static double get_danceability(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/analysis/songs", "danceability");
    }

    public static double get_duration(H5File h5) throws Exception {
        return get_duration(h5, 0);
    }

    public static double get_duration(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/analysis/songs", "duration");
    }

    public static double get_end_of_fade_in(H5File h5) throws Exception {
        return get_end_of_fade_in(h5, 0);
    }

    public static double get_end_of_fade_in(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/analysis/songs", "end_of_fade_in");
    }

    public static double get_energy(H5File h5) throws Exception {
        return get_energy(h5, 0);
    }

    public static double get_energy(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/analysis/songs", "energy");
    }

    public static int get_key(H5File h5) throws Exception {
        return get_key(h5, 0);
    }

    public static int get_key(H5File h5, int songidx) throws Exception {
        return get_member_int(h5, songidx, "/analysis/songs", "key");
    }

    public static double get_key_confidence(H5File h5) throws Exception {
        return get_key_confidence(h5, 0);
    }

    public static double get_key_confidence(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/analysis/songs", "key_confidence");
    }

    public static double get_loudness(H5File h5) throws Exception {
        return get_loudness(h5, 0);
    }

    public static double get_loudness(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/analysis/songs", "loudness");
    }

    public static int get_mode(H5File h5) throws Exception {
        return get_mode(h5, 0);
    }

    public static int get_mode(H5File h5, int songidx) throws Exception {
        return get_member_int(h5, songidx, "/analysis/songs", "mode");
    }

    public static double get_mode_confidence(H5File h5) throws Exception {
        return get_mode_confidence(h5, 0);
    }

    public static double get_mode_confidence(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/analysis/songs", "mode_confidence");
    }

    public static double get_start_of_fade_out(H5File h5) throws Exception {
        return get_start_of_fade_out(h5, 0);
    }

    public static double get_start_of_fade_out(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/analysis/songs", "start_of_fade_out");
    }

    public static double get_tempo(H5File h5) throws Exception {
        return get_tempo(h5, 0);
    }

    public static double get_tempo(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/analysis/songs", "tempo");
    }

    public static int get_time_signature(H5File h5) throws Exception {
        return get_time_signature(h5, 0);
    }

    public static int get_time_signature(H5File h5, int songidx) throws Exception {
        return get_member_int(h5, songidx, "/analysis/songs", "time_signature");
    }

    public static double get_time_signature_confidence(H5File h5) throws Exception {
        return get_time_signature_confidence(h5, 0);
    }

    public static double get_time_signature_confidence(H5File h5, int songidx) throws Exception {
        return get_member_double(h5, songidx, "/analysis/songs", "time_signature_confidence");
    }

    public static String get_track_id(H5File h5) throws Exception {
        return get_track_id(h5, 0);
    }

    public static String get_track_id(H5File h5, int songidx) throws Exception {
        return get_member_string(h5, songidx, "/analysis/songs", "track_id");
    }

    public static double[] get_segments_start(H5File h5) throws Exception {
        return get_segments_start(h5, 0);
    }

    public static double[] get_segments_start(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "analysis", "segments_start", 1);
    }

    public static double[] get_segments_confidence(H5File h5) throws Exception {
        return get_segments_confidence(h5, 0);
    }

    public static double[] get_segments_confidence(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "analysis", "segments_confidence", 1);
    }

    public static double[] get_segments_pitches(H5File h5) throws Exception {
        return get_segments_pitches(h5, 0);
    }

    public static double[] get_segments_pitches(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "analysis", "segments_pitches", 2);
    }

    public static double[] get_segments_timbre(H5File h5) throws Exception {
        return get_segments_timbre(h5, 0);
    }

    public static double[] get_segments_timbre(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "analysis", "segments_timbre", 2);
    }

    public static double[] get_segments_loudness_max(H5File h5) throws Exception {
        return get_segments_loudness_max(h5, 0);
    }

    public static double[] get_segments_loudness_max(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "analysis", "segments_loudness_max", 1);
    }

    public static double[] get_segments_loudness_max_time(H5File h5) throws Exception {
        return get_segments_loudness_max_time(h5, 0);
    }

    public static double[] get_segments_loudness_max_time(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "analysis", "segments_loudness_max_time", 1);
    }

    public static double[] get_segments_loudness_start(H5File h5) throws Exception {
        return get_segments_loudness_start(h5, 0);
    }

    public static double[] get_segments_loudness_start(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "analysis", "segments_loudness_start", 1);
    }

    public static double[] get_sections_start(H5File h5) throws Exception {
        return get_sections_start(h5, 0);
    }

    public static double[] get_sections_start(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "analysis", "sections_start", 1);
    }

    public static double[] get_sections_confidence(H5File h5) throws Exception {
        return get_sections_confidence(h5, 0);
    }

    public static double[] get_sections_confidence(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "analysis", "sections_confidence", 1);
    }

    public static double[] get_beats_start(H5File h5) throws Exception {
        return get_beats_start(h5, 0);
    }

    public static double[] get_beats_start(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "analysis", "beats_start", 1);
    }

    public static double[] get_beats_confidence(H5File h5) throws Exception {
        return get_beats_confidence(h5, 0);
    }

    public static double[] get_beats_confidence(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "analysis", "beats_confidence", 1);
    }

    public static double[] get_bars_start(H5File h5) throws Exception {
        return get_bars_start(h5, 0);
    }

    public static double[] get_bars_start(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "analysis", "bars_start", 1);
    }

    public static double[] get_bars_confidence(H5File h5) throws Exception {
        return get_bars_confidence(h5, 0);
    }

    public static double[] get_bars_confidence(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "analysis", "bars_confidence", 1);
    }

    public static double[] get_tatums_start(H5File h5) throws Exception {
        return get_tatums_start(h5, 0);
    }

    public static double[] get_tatums_start(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "analysis", "tatums_start", 1);
    }

    public static double[] get_tatums_confidence(H5File h5) throws Exception {
        return get_tatums_confidence(h5, 0);
    }

    public static double[] get_tatums_confidence(H5File h5, int songidx) throws Exception {
        return get_array_double(h5, songidx, "analysis", "tatums_confidence", 1);
    }

    public static int get_year(H5File h5) throws Exception {
        return get_year(h5, 0);
    }

    public static int get_year(H5File h5, int songidx) throws Exception {
        return get_member_int(h5, songidx, "/musicbrainz/songs", "year");
    }

    public static String[] get_artist_mbtags(H5File h5) throws Exception {
        return get_artist_mbtags(h5, 0);
    }

    public static String[] get_artist_mbtags(H5File h5, int songidx) throws Exception {
        return get_array_string(h5, songidx, "musicbrainz", "artist_mbtags");
    }

    public static int[] get_artist_mbtags_count(H5File h5) throws Exception {
        return get_artist_mbtags_count(h5, 0);
    }

    public static int[] get_artist_mbtags_count(H5File h5, int songidx) throws Exception {
        return get_array_int(h5, songidx, "musicbrainz", "artist_mbtags_count", "idx_artist_mbtags");
    }

    /********************************** UTILITY FUNCTIONS ************************************/

    /**
     * Slow utility function.
     */
    public static int find(String[] tab, String key) {
        for (int k = 0; k < tab.length; k++)
            if (tab[k].equals(key)) return k;
        return -1;
    }

    public static int get_member_int(H5File h5, int songidx, String table, String member) throws Exception {
        H5CompoundDS analysis = (H5CompoundDS) h5.get(table);
        analysis.init();
        int wantedMember = find(analysis.getMemberNames(), member);
        assert (wantedMember >= 0);
        Vector alldata = (Vector) analysis.getData();
        int[] col = (int[]) alldata.get(wantedMember);
        return col[songidx];
    }

    public static double get_member_double(H5File h5, int songidx, String table, String member) throws Exception {
        H5CompoundDS analysis = (H5CompoundDS) h5.get(table);
        analysis.init();
        int wantedMember = find(analysis.getMemberNames(), member);
        assert (wantedMember >= 0);
        Vector alldata = (Vector) analysis.getData();
        double[] col = (double[]) alldata.get(wantedMember);
        return col[songidx];
    }

    public static String get_member_string(H5File h5, int songidx, String table, String member) throws Exception {
        H5CompoundDS analysis = (H5CompoundDS) h5.get(table);
        analysis.init();
        int wantedMember = find(analysis.getMemberNames(), member);
        assert (wantedMember >= 0);
        Vector alldata = (Vector) analysis.getData();
        String[] col = (String[]) alldata.get(wantedMember);
        return col[songidx];
    }

    public static double[] get_array_double(H5File h5, int songidx, String group, String arrayname, int ndims) throws Exception {
        return get_array_double(h5, songidx, group, arrayname, ndims, "");
    }

    public static double[] get_array_double(H5File h5, int songidx, String group, String arrayname, int ndims, String idxname) throws Exception {
        // index
        H5CompoundDS analysis = (H5CompoundDS) h5.get(group + "/songs");
        analysis.init();
        if (idxname.equals("")) idxname = "idx_" + arrayname;
        int wantedMember = find(analysis.getMemberNames(), idxname);
        assert (wantedMember >= 0);
        Vector alldata = (Vector) analysis.getData();
        int[] col = (int[]) alldata.get(wantedMember);
        int pos1 = col[songidx];
        // data
        H5ScalarDS array = (H5ScalarDS) h5.get("/" + group + "/" + arrayname);
        if (ndims == 1) {
            if (array.getWidth() == 0) {
                return null;
            }
            double[] data = (double[]) array.getData();
            int pos2 = data.length;
            if (songidx + 1 < col.length) pos2 = col[songidx + 1];
            // copy
            double[] res = new double[pos2 - pos1];
            for (int k = 0; k < res.length; k++)
                res[k] = data[pos1 + k];
            return res;
        } else if (ndims == 2) // multiply by 12
        {
            pos1 *= 12;
            double[] data = (double[]) array.getData();
            int pos2 = data.length;
            if (songidx + 1 < col.length) pos2 = col[songidx + 1] * 12;
            // copy
            double[] res = new double[pos2 - pos1];
            for (int k = 0; k < res.length; k++)
                res[k] = data[pos1 + k];
            return res;
        }
        // more than 2 dims?
        return null;
    }

    public static int[] get_array_int(H5File h5, int songidx, String group, String arrayname) throws Exception {
        return get_array_int(h5, songidx, group, arrayname, "");
    }

    public static int[] get_array_int(H5File h5, int songidx, String group, String arrayname, String idxname) throws Exception {
        // index
        H5CompoundDS analysis = (H5CompoundDS) h5.get(group + "/songs");
        analysis.init();
        if (idxname.equals("")) idxname = "idx_" + arrayname;
        int wantedMember = find(analysis.getMemberNames(), idxname);
        assert (wantedMember >= 0);
        Vector alldata = (Vector) analysis.getData();
        int[] col = (int[]) alldata.get(wantedMember);
        int pos1 = col[songidx];
        // data
        H5ScalarDS array = (H5ScalarDS) h5.get("/" + group + "/" + arrayname);

        try {
            int[] data = (int[]) array.getData();
            int pos2 = data.length;
            if (songidx + 1 < col.length) pos2 = col[songidx + 1];
            // copy
            int[] res = new int[pos2 - pos1];
            for (int k = 0; k < res.length; k++)
                res[k] = data[pos1 + k];
            return res;
        } catch(HDF5Exception e) {
            return new int[0];
        }
    }

    public static String[] get_array_string(H5File h5, int songidx, String group, String arrayname) throws Exception {
        // index
        H5CompoundDS analysis = (H5CompoundDS) h5.get(group + "/songs");
        analysis.init();
        int wantedMember = find(analysis.getMemberNames(), "idx_" + arrayname);
        assert (wantedMember >= 0);
        Vector alldata = (Vector) analysis.getData();
        int[] col = (int[]) alldata.get(wantedMember);
        int pos1 = col[songidx];
        // data
        H5ScalarDS array = (H5ScalarDS) h5.get("/" + group + "/" + arrayname);

        try {
            String[] data = (String[]) array.getData();
            int pos2 = data.length;
            if (songidx + 1 < col.length) pos2 = col[songidx + 1];
            // copy
            String[] res = new String[pos2 - pos1];
            for (int k = 0; k < res.length; k++)
                res[k] = data[pos1 + k];
            return res;
        } catch(HDF5Exception e) {
            return new String[0];
        }
    }

    /**
     * *************************************** MAIN ****************************************
     */


    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("file 'hdf5_getters.java'");
            System.out.println("T. Bertin-Mahieux (2010) tb2332@columbia.edu");
            System.out.println("a util static class to read HDF5 song files from");
            System.out.println("the Million Songs Dataset project");
            System.out.println("demo:");
            System.out.println("   see README.txt to compile");
            System.out.println("   java hdf5_getters <some HDF5 song file>");
            System.exit(0);
        }

        List<Path> list = new ArrayList<>();

//        try (DirectoryStream<Path> ds = Files.newDirectoryStream(FileSystems.getDefault().getPath(args[0]), new DirectoryStream.Filter<Path>() {
//            @Override
//            public boolean accept(Path entry) throws IOException {
//                return entry.toFile().isDirectory();
//            }
//        })) {
//            for (Path child : ds) {
//                System.out.println(child);
//            }
//        }

        final List<Path> files = new ArrayList<>();
        Files.walkFileTree(Paths.get(args[0]), new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                files.add(file);
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }
        });

        for (Path file : files) {
            parseFileToSong(file.toFile().getAbsolutePath());
        }
        //parseFileToSong(args[0]);

    }

    private static void parseFileToSong(String filename) {
        //System.out.println("file: " + filename);
        H5File h5 = hdf5_open_readonly(filename);
        Song song = new Song();

        int nSongs = get_num_songs(h5);
        song.setnSongs(nSongs);
        //System.out.println("numberof songs: " + nSongs);
        if (nSongs > 1) System.out.println("we'll display infor for song 0");
        try {
            double[] res;
            String[] resS;
            int[] resI;
            // metadata

            song.setSong_id(get_song_id(h5));

            song.setArtist_familiarity(get_artist_familiarity(h5));
            song.setArtist_hotttnesss(get_artist_hotttnesss(h5));
            song.setArtist_id(get_artist_id(h5));
            song.setArtist_mbid(get_artist_mbid(h5));
            song.setArtist_playmeid(get_artist_playmeid(h5));
            song.setArtist_7digitalid(get_artist_7digitalid(h5));
            song.setArtist_latitude(get_artist_latitude(h5));
            song.setArtist_longitude(get_artist_longitude(h5));
            song.setArtist_location(get_artist_location(h5));
            song.setArtist_name(get_artist_name(h5));
            song.setRelease(get_release(h5));
            song.setRelease_7digitalid(get_release_7digitalid(h5));
            song.setSong_hotttnesss(get_song_hotttnesss(h5));
            song.setTitle(get_title(h5));
            song.setTrack_7digitalid(get_track_7digitalid(h5));

//            System.out.println("artist familiarity: " + get_artist_familiarity(h5));
//            System.out.println("artist hotttnesss: " + get_artist_hotttnesss(h5));
//            System.out.println("artist id: " + get_artist_id(h5));
//            System.out.println("artist mbid: " + get_artist_mbid(h5));
//            System.out.println("artist playmeid: " + get_artist_playmeid(h5));
//            System.out.println("artist 7digitalid: " + get_artist_7digitalid(h5));
//            System.out.println("artist latitude: " + get_artist_latitude(h5));
//            System.out.println("artist longitude: " + get_artist_longitude(h5));
//            System.out.println("artist location: " + get_artist_location(h5));
//            System.out.println("artist name: " + get_artist_name(h5));
//            System.out.println("release: " + get_release(h5));
//            System.out.println("release 7digitalid: " + get_release_7digitalid(h5));
//            System.out.println("song hotttnesss: " + get_song_hotttnesss(h5));
//            System.out.println("title: " + get_title(h5));
//            System.out.println("track 7digitalid: " + get_track_7digitalid(h5));


            resS = get_similar_artists(h5);
            song.setSimilar_artists(resS);

//            if (resS.length != 0) {
//                System.out.println("similar artists, length: " + resS.length + ", elem 2: " + resS[20]);
//            }
            resS = get_artist_terms(h5);
            song.setArtist_terms(resS);
//            if (resS.length != 0) {
//                System.out.println("artists terms, length: " + resS.length + ", elem 0: " + resS[0]);
//            }
            res = get_artist_terms_freq(h5);
            song.setArtist_terms_freq(res);
//            System.out.println("artists terms freq, length: " + res.length + ", elem 0: " + res[0]);
            res = get_artist_terms_weight(h5);
            song.setArtist_terms_weight(res);
//            System.out.println("artists terms weight, length: " + res.length + ", elem 0: " + res[0]);
            // analysis

            song.setDuration(get_duration(h5));
            song.setEnd_of_fade_in(get_end_of_fade_in(h5));
            song.setKey(get_key(h5));
            song.setKey_confidence(get_key_confidence(h5));
            song.setLoudness(get_loudness(h5));
            song.setMode(get_mode(h5));
            song.setMode_confidence(get_mode_confidence(h5));


//            System.out.println("duration: " + get_duration(h5));
//            System.out.println("end_of_fade_in: " + get_end_of_fade_in(h5));
//            System.out.println("key: " + get_key(h5));
//            System.out.println("key confidence: " + get_key_confidence(h5));
//            System.out.println("loudness: " + get_loudness(h5));
//            System.out.println("mode: " + get_mode(h5));
//            System.out.println("mode confidence: " + get_mode_confidence(h5));

            song.setStart_of_fade_out(get_start_of_fade_out(h5));
            song.setTempo(get_tempo(h5));
            song.setTime_signature(get_time_signature(h5));
            song.setTime_signature_confidence(get_time_signature_confidence(h5));

//            System.out.println("start of fade out: " + get_start_of_fade_out(h5));
//            System.out.println("tempo: " + get_tempo(h5));
//            System.out.println("time signature: " + get_time_signature(h5));
//            System.out.println("time signature confidence: " + get_time_signature_confidence(h5));


            song.setSegments_start(get_segments_start(h5));
            song.setSegments_confidence(get_segments_confidence(h5));
            song.setSegments_pitches(get_segments_pitches(h5));
            song.setSegments_timbre(get_segments_timbre(h5));
            song.setSegments_loudness_max(get_segments_loudness_max(h5));
            song.setSegments_loudness_max_time(get_segments_loudness_max_time(h5));
            // TODO: max start ou start
            song.setSegments_loudness_max_start(get_segments_loudness_start(h5));

//            res = get_segments_start(h5);
//            System.out.println("segments start, length: " + res.length + ", elem 20: " + res[20]);
//            res = get_segments_confidence(h5);
//            System.out.println("segments confidence, length: " + res.length + ", elem 20: " + res[20]);
//            res = get_segments_pitches(h5);
//            System.out.println("segments pitches, length: " + res.length + ", elem 20: " + res[20]);
//            res = get_segments_timbre(h5);
//            System.out.println("segments timbre, length: " + res.length + ", elem 20: " + res[20]);
//            res = get_segments_loudness_max(h5);
//            System.out.println("segments loudness max, length: " + res.length + ", elem 20: " + res[20]);
//            res = get_segments_loudness_max_time(h5);
//            System.out.println("segments loudness max time, length: " + res.length + ", elem 20: " + res[20]);
//            res = get_segments_loudness_start(h5);
//            System.out.println("segments loudness start, length: " + res.length + ", elem 20: " + res[20]);

            song.setSections_start(get_sections_start(h5));
            song.setSections_confidence(get_sections_confidence(h5));


//            res = get_sections_start(h5);
//            System.out.println("sections start, length: " + res.length + ", elem 1: " + res[1]);
//            res = get_sections_confidence(h5);
//            System.out.println("sections confidence, length: " + res.length + ", elem 1: " + res[1]);

            song.setBeats_start(get_beats_start(h5));
            song.setBeats_confidence(get_beats_confidence(h5));

//            res = get_beats_start(h5);
//            System.out.println("beats start, length: " + res.length + ", elem 1: " + res[1]);
//            res = get_beats_confidence(h5);
//            System.out.println("beats confidence, length: " + res.length + ", elem 1: " + res[1]);

            song.setBars_start(get_bars_start(h5));
            song.setBars_confidence(get_bars_confidence(h5));


//            res = get_bars_start(h5);
//            System.out.println("bars start, length: " + res.length + ", elem 1: " + res[1]);
//            res = get_bars_confidence(h5);
//            System.out.println("bars confidence, length: " + res.length + ", elem 1: " + res[1]);


            song.setTatums_start(get_tatums_start(h5));
            song.setTatums_confidence(get_tatums_confidence(h5));


//            res = get_tatums_start(h5);
//            System.out.println("tatums start, length: " + res.length + ", elem 3: " + res[3]);
//            res = get_tatums_confidence(h5);
//            System.out.println("tatums confidence, length: " + res.length + ", elem 3: " + res[3]);
            // musicbrainz

            song.setYear(get_year(h5));
            song.setArtist_mbtags(get_artist_mbtags(h5));
            song.setArtist_mbtags_count(get_artist_mbtags_count(h5));

//            System.out.println("year: " + get_year(h5));
//            resS = get_artist_mbtags(h5);
//            resI = get_artist_mbtags_count(h5);
//            if (resS.length > 0) {
//                System.out.println("artists mbtags, length: " + resS.length + ", elem 0: " + resS[0]);
//                System.out.println("artists mbtags count, length: " + resI.length + ", elem 0: " + resI[0]);
//            } else {
//                System.out.println("artists mbtags, length: " + resS.length);
//                System.out.println("artists mbtags count, length: " + resI.length);
//            }

            songs.save(song);


            IndexResponse response = client.prepareIndex("mercenary2", "song", song.getId())
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("artistName", song.getArtist_name())
                            .field("title", song.getTitle())
                            .field("year", song.getYear())
                            .field("city", song.getArtist_location())
                            .endObject()
                    )
                    .execute()
                    .actionGet();


            System.out.println(song.getId());

        } catch (Exception e) {
            System.out.println("something went wrong:");
            e.printStackTrace();
        }
        hdf5_close(h5);
    }


}
