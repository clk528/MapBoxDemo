package com.clk528.mapboxdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.clk528.mapboxdemo.R;
import com.clk528.mapboxdemo.factory.MapReady;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;

import android.view.View;
import android.app.AlertDialog;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {//} implements View.OnClickListener {

    private MapView mapView;

//    private AlertDialog dialog;

//    private MapReady mapReady;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Mapbox.getInstance(getApplicationContext(), getString(R.string.mapbox_access_token));

        setContentView(R.layout.activity_main);

        mapView = (MapView) findViewById(R.id.mapView);

        Button button = (Button) findViewById(R.id.jump);

        mapView.onCreate(savedInstanceState);

        MapReady mapReady = new MapReady();

        mapView.getMapAsync(mapReady);

        button.setOnClickListener(mapReady);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /*@Override
    public void onClick(View v) {
//        dialog = new AlertDialog.Builder(this)
//                .setTitle("提示")
//                .setMessage("我是提示啦")
//                .create();

        mapReady.onClick(v);


        dialog.show();

//        Timer timer = new Timer();
//
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                dialog.dismiss();
//            }
//        }, 1500);

    }*/
}
