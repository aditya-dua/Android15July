package com.adityadua.googlemapsdemo;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;


// We have a listener which is called by the Map Fragment whenever the MAp is reday to be shwon
/// So this listener will be basically implements in this activity
// and then we will over ride the method :: onMapReady()...

public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpMapWhenNeeded();
    }

    private void setUpMapWhenNeeded(){
        MapFragment mapFragment= (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.addMarker(new MarkerOptions().position(new LatLng(28.4640754,77.2922331)).title("My Home"));

        UiSettings ui = googleMap.getUiSettings();
        googleMap.setMyLocationEnabled(true);
        ui.setZoomControlsEnabled(true);
        ui.setMyLocationButtonEnabled(true);
        /*boolean value = ui.isMyLocationButtonEnabled();
        Toast.makeText(this, "The value of my location button is "+value, Toast.LENGTH_SHORT).show();
        */
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(28.4640754,77.2922331));

        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);

        googleMap.moveCamera(center);
        googleMap.animateCamera(zoom);

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                double latitude = latLng.latitude;
                double longitude = latLng.longitude;

                Geocoder geocoder;
                List<Address> addresses;

                geocoder = new Geocoder(MainActivity.this, Locale.getDefault());

                try{
                    addresses = geocoder.getFromLocation(latitude,longitude,1);
                    String address = addresses.get(0).getAddressLine(0);

                    String city = addresses.get(0).getLocality();

                    String state = addresses.get(0).getAdminArea();
                    String country = addresses.get(0).getCountryName();
                    String postalCode = addresses.get(0).getPostalCode();

                    String knownName = addresses.get(0).getFeatureName();

                    String finalAddress= knownName+"\n"+address+"\n"+
                            city+"\n"+state+"\n"+country+"\n"+postalCode;

                    Toast.makeText(MainActivity.this, "Location clicked is \n"+finalAddress, Toast.LENGTH_SHORT).show();
                }catch (Exception e){

                }
            }
        });

    }
}
