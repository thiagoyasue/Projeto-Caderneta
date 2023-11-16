package com.cadsaude.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

public class MainActivity_fem {

    private Button button_id_1;
    private Button button_id_5;
    private ScrollView sv_libras;

    boolean IsOpen = true;

    private Toolbar myToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fem);
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setBackgroundColor(Color.parseColor("#B7B777FF"));
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(null);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        button_id_1 = (Button) findViewById(R.id.b_1);
        button_id_5 = (Button) findViewById(R.id.b_5);

        //sv_libras é a ScrollView do vídeo em libras
        sv_libras = (ScrollView) findViewById(R.id.sv1);

        //localização do video
        VideoView videoView = findViewById(R.id.video_view);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.higiene_bucal;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);


        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        openLibras();

        //ir pra introdução
        button_id_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_id_1();
            }
        });
        //ir pra higiene bucal
        button_id_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_id_5();
            }
        });

    }

    public void open_id_1() {
        Intent intent = new Intent(this, geral_adolescencia_1.class);
        startActivity(intent);
    }

    public void open_id_5() {
        Intent intent = new Intent(this, geral_higienebucal_1.class);
        startActivity(intent);
    }


    public void openLibras() {
        if(IsOpen){
            sv_libras.setVisibility(LinearLayout.GONE);
            sv_libras.getLayoutParams().height= 0;
            IsOpen = false;
        }
        else{
            sv_libras.setVisibility(LinearLayout.VISIBLE);

            //cálculo para conversão de pixels para a unidade dip (Pro video ficar visivel novamente, com o tamanho que ele tinha antes)
            final float scale = getResources().getDisplayMetrics().density;
            int dpWidthInPx  = (int) (200 * scale);

            sv_libras.getLayoutParams().height= dpWidthInPx;
            IsOpen = true;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_child, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_libras:
                openLibras();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}