package com.example.ihcl_m;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class video extends AppCompatActivity implements View.OnClickListener {

    private VideoView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        v = (VideoView) findViewById(R.id.videoView);

        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.video;

        Uri uri = Uri.parse(videopath);
        v.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        v.setMediaController(mediaController);
        mediaController.setAnchorView(v);
        v.setOnPreparedListener(mediaPlayer -> v.start());
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(video.this, video.class);
        startActivity(intent);
    }
}