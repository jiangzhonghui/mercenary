package com.zebia.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.zebia.MapActivity;
import com.zebia.R;
import com.zebia.model.Item;

public class ItemDetailsFragment extends Fragment {
    private int index;
    private Item item;

    /**
     * Create a new instance of ItemDetailsFragment, initialized to
     * show the text at 'index'.
     */
//    public static ItemDetailsFragment newInstance(int index) {
//        ItemDetailsFragment f = new ItemDetailsFragment();
//
//        // Supply index input as an argument.
//        Bundle args = new Bundle();
//        args.putInt("index", index);
//        f.setArguments(args);
//
//        return f;
//    }
    public ItemDetailsFragment() {
    }

    public ItemDetailsFragment(int index, Item item) {
        this.index = index;
        this.item = item;
    }

//    public int getShownIndex() {
//        return getArguments().getInt("index", 0);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        if (item != null) {
            return inflater.inflate(R.layout.item_detail, container, false);
        } else {
            ScrollView scroller = new ScrollView(getActivity());
            TextView text = new TextView(getActivity());
            int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    4, getActivity().getResources().getDisplayMetrics());
            text.setPadding(padding, padding, padding, padding);
            scroller.addView(text);
            text.setText("Chose an item...");
            return scroller;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (item != null) {
            TextView txFromUser = (TextView) getView().findViewById(R.id.tx_detail_item_from_user);
            TextView txText = (TextView) getView().findViewById(R.id.tx_detail_item_text);
            TextView txTextLong = (TextView) getView().findViewById(R.id.tx_detail_item_text_long);

            txFromUser.setText(item.getFromUserName());
            txText.setText(item.getText());
            txTextLong.setText(item.getTextLong());

            ImageButton mapButton = (ImageButton) getView().findViewById(R.id.map_btn);
            mapButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    String location = new Gson().toJson(item.getLocation());
                    Log.d("zebia", "location " + location);

                    bundle.putString(MapActivity.ONE_LOCATION, location);
                    Intent openMapIntent = new Intent(getActivity(), MapActivity.class).putExtras(bundle);
                    startActivity(openMapIntent);

                }
            });
        }
    }

    public int getIndex() {
        return index;
    }

    public Item getItem() {
        return item;
    }
}
