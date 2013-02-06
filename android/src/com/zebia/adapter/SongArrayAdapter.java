package com.zebia.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import com.zebia.R;
import com.zebia.model.Artist;
import com.zebia.model.Song;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SongArrayAdapter extends ArrayAdapter<Artist> {
    //static final int DELTA = 60 * 60000;
    //static final int COLOR_STATUS = Color.parseColor("#a9f300");
    //static final int COLOR_OWNER = Color.parseColor("#ffb200");

    Context context;
    int layoutResourceId;

    public SongArrayAdapter(Context context) {
        super(context, R.layout.artist_list_item);
        this.layoutResourceId = R.layout.artist_list_item;
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
            holder.txtArtistName = (TextView) row.findViewById(R.id.tx_artist_name);
            holder.txtArtistId = (TextView) row.findViewById(R.id.tx_artist_id);
            holder.txtArtistLocation = (TextView) row.findViewById(R.id.tx_artist_location);
            holder.txtArtistMbTags = (TextView) row.findViewById(R.id.tx_artist_tags);
            holder.favoriBton = (ImageButton) row.findViewById(R.id.btn_favoris);

            row.setTag(holder);
        } else {
            holder = (SongHolder) row.getTag();
        }
        Object object = getItem(position);

        holder.fromSong(getItem(position));

        return row;
    }

    static class SongHolder {

        static SimpleDateFormat df;
        static {
            df = new SimpleDateFormat("mm:ss");
            df.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        TextView txtArtistId;
        TextView txtArtistName;
        TextView txtArtistLocation;
        TextView txtArtistMbTags;
        ImageButton favoriBton;

        public void fromSong(Artist artist) {
            txtArtistName.setText(artist.getArtist_name());
            txtArtistId.setText(artist.getArtist_id());
            txtArtistLocation.setText(artist.getArtist_location());
            txtArtistMbTags.setText(artist.getArtist_tags().toString());
            //favoriBton.setBackground();TODO
        }

        private String durationToStr(float durationMs) {
            return df.format(new Date((int)durationMs * 1000));
        }

    }

}
