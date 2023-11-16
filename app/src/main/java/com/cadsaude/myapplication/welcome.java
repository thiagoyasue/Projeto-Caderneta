package com.cadsaude.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class welcome {

    private Button button_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        button_continue = (Button) findViewById(R.id.button);

        //localização do video01
        VideoView videoView = findViewById(R.id.video_view);
        String videoPath = "android.resource://"+getPackageName()+"/"+R.raw.higiene_bucal;
        //String videoPath = "android.resource://"+getPackageName()+"/"+R.raw.novo_eca_1;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        GetButtonContinue();
    }

    private void GetButtonContinue(){
        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_Settings();
            }
        });
    }

    private void OpenScene_Settings(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}
