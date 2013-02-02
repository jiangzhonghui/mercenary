package com.zebia;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import com.zebia.adapter.SongDetailsCollectionAdapter;

public class SongDetailsActivity extends FragmentActivity {

    private ViewPager viewPager;
    private SongDetailsCollectionAdapter songDetailsCollectionAdapter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_detail_pager);

        songDetailsCollectionAdapter = new SongDetailsCollectionAdapter(getSupportFragmentManager());

        int songIndex = 0;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            songIndex = bundle.getInt(SongActivity.SONG_INDEX, 0);
        }

        final ActionBar actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(false);

        viewPager = (ViewPager) findViewById(R.id.pager_song_details);
        viewPager.setAdapter(songDetailsCollectionAdapter);
        viewPager.setCurrentItem(songIndex);

        getActionBar().setDisplayShowTitleEnabled(false);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
