package com.zebia;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.zebia.fragments.ItemDetailsFragment;
import com.zebia.fragments.ItemListFragment;
import com.zebia.model.Item;

public class ItemActivity extends FragmentActivity implements ItemListFragment.OnItemSelectedListener {
    private boolean mDualPane;
    private int mCurCheckPosition = 0;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        ItemListFragment itemListFragment = new ItemListFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.list_item_fragment_layout, itemListFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        // Check to see if we have a frame in which to embed the details fragment directly in the containing UI.
        View detailsFrame = findViewById(R.id.details_item);
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null) {
            //getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE); // TODO

            // Restore last state for checked position.
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }

        if (mDualPane) {
            showDetails(mCurCheckPosition, null);
        }
    }


    void showDetails(int index, Item item) {
        mCurCheckPosition = index;

        // Check what fragment is currently shown, replace if needed.
        ItemDetailsFragment details = (ItemDetailsFragment)
                getSupportFragmentManager().findFragmentById(R.id.details_item);

        if (details == null || details.getIndex() != mCurCheckPosition) {
            // Make new fragment to show this selection.
            details = new ItemDetailsFragment(index, item);

            // Execute a transaction, replacing any existing fragment
            // with this one inside the frame.
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

            if (mDualPane) {
                ft.replace(R.id.details_item, details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            } else {
                ft.replace(R.id.list_item_fragment_layout, details);
                ft.addToBackStack(null);
            }

            ft.commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }

    // Fragment callback
    @Override
    public void onItemSelected(int index, Item item) {
        showDetails(index, item);
    }
}
