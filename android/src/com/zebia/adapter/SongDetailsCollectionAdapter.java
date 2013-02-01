package com.zebia.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.zebia.SongActivity;
import com.zebia.fragments.SongDetailsFragment;
import com.zebia.model.SongStore;

public class SongDetailsCollectionAdapter extends FragmentStatePagerAdapter {
    public SongDetailsCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment = new SongDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(SongActivity.SONG_INDEX, i);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getCount() {
        return SongStore.get().size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return SongStore.get(position).getArtist_name();
    }
}
