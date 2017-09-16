package com.adityadua.googlemaps;

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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

setupMap();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setupMap();
    }

    private  void setupMap(){
        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions().position(new LatLng(28.461301, 77.290536)).title("My Home"));

        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(28.461301, 77.290536));

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

                geocoder = new Geocoder(MainActivity.this, Locale.FRANCE);


                try{
                    addresses = geocoder.getFromLocation(latitude,longitude,1);

                    String marker=addresses.get(0).getFeatureName();
                    String address = addresses.get(0).getAddressLine(0);

                    address= address+"\n"+addresses.get(0).getLocality();
                    address= address+"\n"+addresses.get(0).getCountryName();

                    Toast.makeText(MainActivity.this, address, Toast.LENGTH_SHORT).show();

                    googleMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(marker));

                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                    CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(latitude,longitude));

                    CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
                    googleMap.moveCamera(center);
                    googleMap.animateCamera(zoom);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
