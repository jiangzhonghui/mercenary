package com.zebia.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.zebia.fragments.SongDetailsFragment;
import com.zebia.model.SongStore;

public class SongDetailsCollectionAdapter extends FragmentStatePagerAdapter {
    public SongDetailsCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return new SongDetailsFragment(i, SongStore.get(i));
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
