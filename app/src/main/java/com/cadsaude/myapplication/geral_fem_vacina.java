package com.cadsaude.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class geral_fem_vacina {
    private LinearLayout sv_libras;
    private LinearLayout sv_libras2;
    private Toolbar myToolbar;
    private MediaController mc, mc2;
    boolean IsOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geral_fem_vacina);
        //adicionar toolbar
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(null);
        //botão de voltar
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        //sv_libras é a ScrollView do vídeo em libras
        sv_libras = (LinearLayout) findViewById(R.id.sv1);
        sv_libras2 = (LinearLayout) findViewById(R.id.sv2);

        //localização do video01
        VideoView videoView = findViewById(R.id.video_view);
        String videoPath = "android.resource://"+getPackageName()+"/"+R.raw.higiene_bucal;
        //String videoPath = "android.resource://"+getPackageName()+"/"+R.raw.vacina_geral_1;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mc = mediaController;
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        //localização do video02
        VideoView videoView2 = findViewById(R.id.video_view2);
        String videoPath2 = "android.resource://"+getPackageName()+"/"+R.raw.higiene_bucal;
        //String videoPath2 = "android.resource://"+getPackageName()+"/"+R.raw.vacina_fem;
        Uri uri2 = Uri.parse(videoPath2);
        videoView2.setVideoURI(uri2);

        MediaController mediaController2 = new MediaController(this);
        mc2 = mediaController;
        videoView2.setMediaController(mediaController2);
        mediaController2.setAnchorView(videoView2);

        openLibras();
    }

    public void openLibras() {
        if(IsOpen){
            sv_libras.setVisibility(LinearLayout.GONE);
            sv_libras.getLayoutParams().height= 0;

            sv_libras2.setVisibility(LinearLayout.GONE);
            sv_libras2.getLayoutParams().height= 0;

            IsOpen = false;
        }
        else{
            sv_libras.setVisibility(LinearLayout.VISIBLE);
            sv_libras2.setVisibility(LinearLayout.VISIBLE);
            //cálculo para conversão de pixels para a unidade dip (Pro video ficar visivel novamente, com o tamanho que ele tinha antes)
            final float scale = getResources().getDisplayMetrics().density;
            int dpWidthInPx  = (int) (340 * scale);

            sv_libras.getLayoutParams().height= dpWidthInPx;
            sv_libras2.getLayoutParams().height= dpWidthInPx;
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
