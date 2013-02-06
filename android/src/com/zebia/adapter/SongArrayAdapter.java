package com.zebia.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
import com.zebia.R;
import com.zebia.model.Song;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SongArrayAdapter extends ArrayAdapter<Song> {
    //static final int DELTA = 60 * 60000;
    //static final int COLOR_STATUS = Color.parseColor("#a9f300");
    //static final int COLOR_OWNER = Color.parseColor("#ffb200");

    Context context;
    int layoutResourceId;

    public SongArrayAdapter(Context context) {
        super(context, R.layout.song_list_item);
        this.layoutResourceId = R.layout.song_list_item;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        SongHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new SongHolder();
            holder.txtSongTitle = (TextView) row.findViewById(R.id.tx_song_title);
            holder.txtSongArtist = (TextView) row.findViewById(R.id.tx_song_artist);
            holder.txtSongRelease = (TextView) row.findViewById(R.id.tx_song_release);
            holder.rtbSongRating = (RatingBar) row.findViewById(R.id.ratingbar_list_song_rating);
            holder.txtSongDuration = (TextView) row.findViewById(R.id.tx_song_duration);

            row.setTag(holder);
        } else {
            holder = (SongHolder) row.getTag();
        }

        holder.fromSong(getItem(position));

        return row;
    }

    static class SongHolder {

        static SimpleDateFormat df;
        static {
            df = new SimpleDateFormat("mm:ss");
            df.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        TextView txtSongTitle;
        TextView txtSongArtist;
        TextView txtSongRelease;
        public RatingBar rtbSongRating;
        public TextView txtSongDuration;

        public void fromSong(Song song) {
            txtSongTitle.setText(song.getTitle());
            txtSongArtist.setText(song.getArtist_name());
            txtSongRelease.setText(song.getRelease());
            rtbSongRating.setRating(song.getEnergy());
            txtSongDuration.setText(durationToStr(song.getDuration()));
        }

        private String durationToStr(float durationMs) {
            return df.format(new Date((int)durationMs * 1000));
        }

    }

}
