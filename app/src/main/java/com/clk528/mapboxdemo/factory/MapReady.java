package com.clk528.mapboxdemo.factory;

import android.support.annotation.NonNull;

import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import android.view.View;

public class MapReady implements OnMapReadyCallback, MapboxMap.OnMapClickListener, View.OnClickListener {

    private MapboxMap mapboxMap;

    @Override
    public void onMapReady(MapboxMap mapboxMap) {

        this.mapboxMap = mapboxMap;


        System.out.println("MapBox 启动完成");
        mapboxMap.addOnMapClickListener(this);
    }

    @Override
    public void onMapClick(@NonNull LatLng point) {
//        System.out.println("Latitude:" + point.getLatitude() + ";Longitude:" + point.getLongitude() + ";Altitude:" + point.getAltitude() + ";zoom:" + mapboxMap.getCameraPosition().zoom);
    }

    @Override
    public void onClick(View view) {
        CameraPosition position = new CameraPosition.Builder()
                .target(new LatLng(31.23713455317329, 121.50481624017016)) // Sets the new camera position
                .zoom(15) // Sets the zoom
                .bearing(0) // Rotate the camera
                .tilt(0) // Set the camera tilt
                .build(); // Creates a CameraPosition from the builder

        mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(position), 2000);
    }
}
