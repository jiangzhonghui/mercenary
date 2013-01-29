package com.zebia;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.zebia.model.Location;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapActivity extends Activity implements GoogleMap.OnMapClickListener, GoogleMap.OnMarkerClickListener {
    public static final String LAT = "latitude";
    public static final String LNG = "longitude";
    public static final String LIST_OF_LOCATIONS = "locationArray";
    public static final String ONE_LOCATION = "onelocation";

    private GoogleMap mMap;
    private Location mInitialLocation;
    private List<Marker> marker = new ArrayList<Marker>();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        Bundle bundle = this.getIntent().getExtras();
        String oneLocationJson = bundle.getString(ONE_LOCATION);
        ArrayList<String> listOflocationsJson = null;
        if( oneLocationJson != null){
            mInitialLocation = new Gson().fromJson(bundle.getString(ONE_LOCATION), Location.class);
        }else{
            listOflocationsJson = bundle.getStringArrayList(LIST_OF_LOCATIONS);
            if(listOflocationsJson != null){
                mInitialLocation = new Gson().fromJson(listOflocationsJson.get(0), Location.class);
            }
        }

      //  mInitialPosition = new LatLng(bunble.getDouble(LAT), bunble.getDouble(LNG));

        setUpMapIfNeeded();
        if(listOflocationsJson != null){
            for(int i=1; i< listOflocationsJson.size(); i++){
                Location location = new Gson().fromJson(listOflocationsJson.get(0), Location.class);
                if(location != null){
                    LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    String address = location.getAddress();

                    addMarker(latLng, address, address);
                }
            }
        }

    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {

            mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

                if(mInitialLocation != null){
                    LatLng latLng = new LatLng(mInitialLocation.getLatitude(), mInitialLocation.getLongitude());
                    Log.d("zebia", "LatLng "+ latLng);
                    String address = mInitialLocation.getAddress();
                    updatePosition(latLng, true);
                    addMarker(latLng, address, "Welcome");
                }

                mMap.setOnMapClickListener(this);
                mMap.setOnMarkerClickListener(this);

            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void updatePosition(LatLng latLng, boolean animation){
        Toast.makeText(this, "changing location", Toast.LENGTH_SHORT).show();
        CameraPosition.Builder cameraPositionBuilder = new CameraPosition.Builder();
        cameraPositionBuilder.target(latLng);

/*
        cameraPositionBuilder.zoom(10);
        cameraPositionBuilder.bearing(0);
        cameraPositionBuilder.tilt(0);
*/
        //CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPositionBuilder.build());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 12);
        if(animation){
            mMap.animateCamera(cameraUpdate, 2000, null);
        }else{

            mMap.moveCamera(cameraUpdate);
        }
    }

    private void addMarker(LatLng latLng, String title, String infos){
        Marker marker = mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title(title)
                .snippet(infos));
    }

    @Override
    public void onMapClick(LatLng latLng) {
        updatePosition(latLng, true);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Toast.makeText(this, "You touch the marker" + marker.toString(), Toast.LENGTH_LONG).show();
        return false;
    }

    private LatLng reverseGeocoding(String locationName){
        final int maxResult = 10;
        Geocoder geoCoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geoCoder.getFromLocationName(locationName, maxResult);
            return new LatLng(addresses.get(0).getLatitude(), addresses.get(0).getLongitude());
        } catch (IOException e) {
            Log.i(MapActivity.class.getName(), "not possible finding LatLng for Address : " + locationName);
        }
        return new LatLng(0, 0);
    }

    private String getAddress(LatLng latLng){
        StringBuilder address = new StringBuilder();
        final int maxResult = 10;

        List<Address> addresses = new ArrayList<Address>(maxResult);
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, maxResult);
            if (addresses.size() > 0)
            {
                Address first = addresses.get(0);
                for (int i=0; i<first.getMaxAddressLineIndex();i++){
                    address.append(first.getAddressLine(i) + " ");
                }
            }
        } catch (IOException e) {
            Log.i(MapActivity.class.getName(), "not possible finding address for LatLng : " + latLng.toString());
        }
        return address.toString();
    }

}