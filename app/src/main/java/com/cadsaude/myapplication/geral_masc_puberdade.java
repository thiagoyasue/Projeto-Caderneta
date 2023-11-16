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

public class geral_masc_puberdade {
    private LinearLayout sv_libras;
    private LinearLayout sv_libras2;
    private LinearLayout sv_libras3;
    private LinearLayout sv_libras4;
    private LinearLayout sv_libras5;
    private LinearLayout sv_libras6;
    private LinearLayout sv_libras7;
    private LinearLayout sv_libras8;

    private Toolbar myToolbar;
    boolean IsOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geral_masc_puberdade);
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
        sv_libras3 = (LinearLayout) findViewById(R.id.sv3);
        sv_libras4 = (LinearLayout) findViewById(R.id.sv4);
        sv_libras5 = (LinearLayout) findViewById(R.id.sv5);
        sv_libras6 = (LinearLayout) findViewById(R.id.sv6);
        sv_libras7 = (LinearLayout) findViewById(R.id.sv7);
        sv_libras8 = (LinearLayout) findViewById(R.id.sv71);

        //localização do video01
        VideoView videoView = findViewById(R.id.video_view);
        //String videoPath = "android.resource://"+getPackageName()+"/"+R.raw.puberdade_masc_1;
        String videoPath = "android.resource://"+getPackageName()+"/"+R.raw.higiene_bucal;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        //localização do video02
        VideoView videoView2 = findViewById(R.id.video_view2);
        //String videoPath2 = "android.resource://"+getPackageName()+"/"+R.raw.puberdade_masc_2;
        String videoPath2 = "android.resource://"+getPackageName()+"/"+R.raw.higiene_bucal;
        Uri uri2 = Uri.parse(videoPath2);
        videoView2.setVideoURI(uri2);

        MediaController mediaController2 = new MediaController(this);
        videoView2.setMediaController(mediaController2);
        mediaController2.setAnchorView(videoView2);

        //localização do video03
        VideoView videoView3 = findViewById(R.id.video_view3);
        //String videoPath3 = "android.resource://"+getPackageName()+"/"+R.raw.puberdade_masc_3;
        String videoPath3 = "android.resource://"+getPackageName()+"/"+R.raw.higiene_bucal;
        Uri uri3 = Uri.parse(videoPath3);
        videoView3.setVideoURI(uri3);

        MediaController mediaController3 = new MediaController(this);
        videoView3.setMediaController(mediaController3);
        mediaController3.setAnchorView(videoView3);

        //localização do video04
        VideoView videoView4 = findViewById(R.id.video_view4);
        //String videoPath4 = "android.resource://"+getPackageName()+"/"+R.raw.puberdade_masc_4;
        String videoPath4 = "android.resource://"+getPackageName()+"/"+R.raw.higiene_bucal;
        Uri uri4 = Uri.parse(videoPath4);
        videoView4.setVideoURI(uri4);

        MediaController mediaController4 = new MediaController(this);
        videoView4.setMediaController(mediaController4);
        mediaController4.setAnchorView(videoView4);

        //localização do video05
        VideoView videoView5 = findViewById(R.id.video_view5);
        //String videoPath5 = "android.resource://"+getPackageName()+"/"+R.raw.puberdade_masc_5;
        String videoPath5 = "android.resource://"+getPackageName()+"/"+R.raw.higiene_bucal;
        Uri uri5 = Uri.parse(videoPath5);
        videoView5.setVideoURI(uri5);

        MediaController mediaController5 = new MediaController(this);
        videoView5.setMediaController(mediaController5);
        mediaController5.setAnchorView(videoView5);

        //localização do video06
        VideoView videoView6 = findViewById(R.id.video_view6);
        //String videoPath6 = "android.resource://"+getPackageName()+"/"+R.raw.puberdade_masc_6;
        String videoPath6 = "android.resource://"+getPackageName()+"/"+R.raw.higiene_bucal;
        Uri uri6 = Uri.parse(videoPath6);
        videoView6.setVideoURI(uri6);

        MediaController mediaController6 = new MediaController(this);
        videoView6.setMediaController(mediaController6);
        mediaController6.setAnchorView(videoView6);

        //localização do video07
        VideoView videoView7 = findViewById(R.id.video_view7);
        //String videoPath7 = "android.resource://"+getPackageName()+"/"+R.raw.puberdade_masc_7;
        String videoPath7 = "android.resource://"+getPackageName()+"/"+R.raw.higiene_bucal;
        Uri uri7 = Uri.parse(videoPath7);
        videoView7.setVideoURI(uri7);

        MediaController mediaController7 = new MediaController(this);
        videoView7.setMediaController(mediaController7);
        mediaController7.setAnchorView(videoView7);

        //localização do video08
        VideoView videoView8 = findViewById(R.id.video_view8);
        //String videoPath8 = "android.resource://"+getPackageName()+"/"+R.raw.puberdade_masc_8;
        String videoPath8 = "android.resource://"+getPackageName()+"/"+R.raw.higiene_bucal;
        Uri uri8 = Uri.parse(videoPath8);
        videoView8.setVideoURI(uri8);

        MediaController mediaController8 = new MediaController(this);
        videoView8.setMediaController(mediaController8);
        mediaController8.setAnchorView(videoView8);

        openLibras();
    }

    public void openLibras() {
        if(IsOpen){
            sv_libras.setVisibility(LinearLayout.GONE);
            sv_libras.getLayoutParams().height= 0;

            sv_libras2.setVisibility(LinearLayout.GONE);
            sv_libras2.getLayoutParams().height= 0;

            sv_libras3.setVisibility(LinearLayout.GONE);
            sv_libras3.getLayoutParams().height= 0;

            sv_libras4.setVisibility(LinearLayout.GONE);
            sv_libras4.getLayoutParams().height= 0;

            sv_libras5.setVisibility(LinearLayout.GONE);
            sv_libras5.getLayoutParams().height= 0;

            sv_libras6.setVisibility(LinearLayout.GONE);
            sv_libras6.getLayoutParams().height= 0;

            sv_libras7.setVisibility(LinearLayout.GONE);
            sv_libras7.getLayoutParams().height= 0;

            sv_libras8.setVisibility(LinearLayout.GONE);
            sv_libras8.getLayoutParams().height= 0;


            IsOpen = false;
        }
        else{
            sv_libras.setVisibility(LinearLayout.VISIBLE);
            sv_libras2.setVisibility(LinearLayout.VISIBLE);
            sv_libras3.setVisibility(LinearLayout.VISIBLE);
            sv_libras4.setVisibility(LinearLayout.VISIBLE);
            sv_libras5.setVisibility(LinearLayout.VISIBLE);
            sv_libras6.setVisibility(LinearLayout.VISIBLE);
            sv_libras7.setVisibility(LinearLayout.VISIBLE);
            sv_libras8.setVisibility(LinearLayout.VISIBLE);

            //cálculo para conversão de pixels para a unidade dip (Pro video ficar visivel novamente, com o tamanho que ele tinha antes)
            final float scale = getResources().getDisplayMetrics().density;
            int dpWidthInPx  = (int) (340 * scale);

            sv_libras.getLayoutParams().height= dpWidthInPx;
            sv_libras2.getLayoutParams().height= dpWidthInPx;
            sv_libras3.getLayoutParams().height= dpWidthInPx;
            sv_libras4.getLayoutParams().height= dpWidthInPx;
            sv_libras5.getLayoutParams().height= dpWidthInPx;
            sv_libras6.getLayoutParams().height= dpWidthInPx;
            sv_libras7.getLayoutParams().height= dpWidthInPx;
            sv_libras8.getLayoutParams().height= dpWidthInPx;

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