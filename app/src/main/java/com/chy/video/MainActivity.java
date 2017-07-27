package com.chy.video;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.chy.video.widget.BDCloudVideoView;


public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";
    BDCloudVideoView bdCloudVideoView;
    String path = Environment.getExternalStorageDirectory().toString() + "/v.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bdCloudVideoView = (BDCloudVideoView) findViewById(R.id.bdv);
        bdCloudVideoView.setVideoPath(path);
        bdCloudVideoView.start();
        Log.e(TAG, bdCloudVideoView.getDuration() + "");
        Log.e(TAG, bdCloudVideoView.getCurrentPosition() + "");

    }
}
