package edu.uw.yw239.maplab;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in the fountain
        LatLng fountain = new LatLng(47.6538, -122.3078);
        mMap.addMarker(new MarkerOptions()
                .position(fountain)
                .title("UW fountain")
                .snippet("Quack Quack Quack")
                .icon(BitmapDescriptorFactory.defaultMarker(260)));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(fountain));
        PolylineOptions polyLine = new PolylineOptions()
                .add(new LatLng(47.65380, -122.30780))
                .add(new LatLng(47.65370, -122.30775))
                .add(new LatLng(47.65380, -122.30770))
                .add(new LatLng(47.65370, -122.30765))
                .add(new LatLng(47.65380, -122.30760))
                .width(25)
                .color(Color.rgb(70,49,126));
        mMap.addPolyline(polyLine);
    }
}
