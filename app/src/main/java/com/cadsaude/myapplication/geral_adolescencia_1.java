package com.cadsaude.myapplication;

import androidx.appcompat;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

public class geral_adolescencia_1 {

    private ScrollView sv_libras;

    private Toolbar myToolbar;


    boolean IsOpen = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geral_adolescencia_1);
        //adicionar toolbar
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(null);
        //botão de voltar
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        //sv_libras é a ScrollView do vídeo em libras
        sv_libras = (ScrollView) findViewById(R.id.sv1);

        //localização do video
        VideoView videoView = findViewById(R.id.video_view);
        //String videoPath = "android.resource://"+getPackageName()+"/"+R.raw.introducao;
        String videoPath = "android.resource://"+getPackageName()+"/"+R.raw.higiene_bucal;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        openLibras();
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
            int dpWidthInPx  = (int) (340 * scale);

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
                // default invoca o retorno
                return super.onOptionsItemSelected(item);

        }
    }
}
