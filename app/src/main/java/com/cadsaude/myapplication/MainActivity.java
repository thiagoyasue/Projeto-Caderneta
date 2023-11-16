package com.cadsaude.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity {

    private Button button_settings;

    private Toolbar myToolbar;

    private LinearLayout cadfem;
    private LinearLayout cadmasc;

    boolean IsOpen = false;

    //Perfil Caderneta
    private TextView txt_nome;
    private TextView txt_data_nasc;
    private TextView txt_enderec;
    private TextView txt_responsavel_nome;
    private TextView txt_responsavel_tel;
    private TextView txt_saude;
    public static final String PREFS_NAME = "PerfilFile";
    private String nome = "null";
    private String data_nasc = "null";
    private String enderec = "null";
    private String responsavel_nome = "null";
    private String responsavel_tel = "null";
    private String saude = "null";
    private int opcoes = 0;

    //Botões caderneta
    private Button button_id_1_m;
    private Button button_id_2_m;
    private Button button_id_3_m;
    private Button button_id_4_m;
    private Button button_id_5_m;
    private Button button_id_6_m;
    private Button button_id_7_m;
    private Button button_id_8_m;
    private Button button_id_9_m;
    private Button button_id_1_f;
    private Button button_id_2_f;
    private Button button_id_3_f;
    private Button button_id_4_f;
    private Button button_id_5_f;
    private Button button_id_6_f;
    private Button button_id_7_f;
    private Button button_id_8_f;
    private Button button_id_9_f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cadfem = (LinearLayout) findViewById(R.id.layout_cadfem);
        cadmasc = (LinearLayout) findViewById(R.id.layout_cadmasc);


        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setBackgroundColor(Color.parseColor("#C8FFC8"));
        setSupportActionBar(myToolbar);

        button_settings = findViewById(R.id.button_settings);

        button_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

        //Acessar infos do perfil
        txt_nome = (TextView) findViewById(R.id.textNome);
        txt_enderec = (TextView) findViewById(R.id.textEnd);
        txt_data_nasc = (TextView) findViewById(R.id.textIdade);
        txt_responsavel_nome = (TextView) findViewById(R.id.textResp);
        txt_responsavel_tel = (TextView) findViewById(R.id.textResp2);
        txt_saude = (TextView) findViewById(R.id.textSaude);
        GetInfoPerfil();

        //Bobões de acesso aos tópicos da caderneta
        button_id_1_m = (Button) findViewById(R.id.b_1);
        button_id_2_m = (Button) findViewById(R.id.b_2);
        button_id_3_m = (Button) findViewById(R.id.b_3);
        button_id_4_m = (Button) findViewById(R.id.b_4);
        button_id_5_m = (Button) findViewById(R.id.b_5);
        button_id_6_m = (Button) findViewById(R.id.b_6);
        button_id_7_m = (Button) findViewById(R.id.b_7);
        button_id_8_m = (Button) findViewById(R.id.b_8);
        button_id_9_m = (Button) findViewById(R.id.b_9);
        button_id_1_f = (Button) findViewById(R.id.b_1f);
        button_id_2_f = (Button) findViewById(R.id.b_2f);
        button_id_3_f = (Button) findViewById(R.id.b_3f);
        button_id_4_f = (Button) findViewById(R.id.b_4f);
        button_id_5_f = (Button) findViewById(R.id.b_5f);
        button_id_6_f = (Button) findViewById(R.id.b_6f);
        button_id_7_f = (Button) findViewById(R.id.b_7f);
        button_id_8_f = (Button) findViewById(R.id.b_8f);
        button_id_9_f = (Button) findViewById(R.id.b_9f);

        GetButtonsMasc();
        GetButtonsFem();
        openLibras();
    }

    private void GetButtonsMasc(){
        //ir pra introdução
        button_id_1_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_Introducao();
            }
        });
        //ir pra ECA
        button_id_2_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_ECA();
            }
        });
        //ir pra dicas de saude
        button_id_3_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_Saude();
            }
        });
        //ir pra ALIMENTACAO
        button_id_4_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_Saude();
            }
        });
        //ir pra higiene bucal
        button_id_5_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_HigieneBucal();
            }
        });
        //ir pra vacinas masc
        button_id_6_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_VacinaMasc();
            }
        });
        //ir pra puberdade fem
        button_id_7_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_PuberdadeMasc();
            }
        });
        //ir pra sexualidade
        button_id_8_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_SexualidadeMasc();
            }
        });
        //ir pra projeto de vida
        button_id_9_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_ProjVida();
            }
        });
    }

    private void GetButtonsFem(){
        //ir pra introdução
        button_id_1_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_Introducao();
            }
        });
        //ir pra ECA
        button_id_2_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_ECA();
            }
        });
        //ir pra dicas de saude
        button_id_3_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_Saude();
            }
        });
        //ir pra ALIMENTACAO
        button_id_4_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_Alimentacao();
            }
        });
        //ir pra higiene bucal
        button_id_5_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_HigieneBucal();
            }
        });
        //ir pra vacinas fem
        button_id_6_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_VacinaFem();
            }
        });
        //ir pra puberdade fem
        button_id_7_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_PuberdadeFem();
            }
        });
        //ir pra sexualidade
        button_id_8_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_SexualidadeFem();
            }
        });
        //ir pra projeto de vida
        button_id_9_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScene_ProjVida();
            }
        });
    }

    private void GetInfoPerfil(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        nome = settings.getString("nome","");
        data_nasc = settings.getInt("data_nasc_dia",01)+"/"+settings.getInt("data_nasc_mes",01)+"/"+settings.getInt("data_nasc_ano",2000);
        enderec = settings.getString("enderec","");
        responsavel_nome = settings.getString("responsavel_nome","");
        responsavel_tel = settings.getString("responsavel_tel","");
        saude = settings.getString("saude","");
        opcoes = settings.getInt("opcoes",0);

        CheckDados();
        GetCaderneta();
    }

    private void GetCaderneta(){
        switch (opcoes){
            case 1:
                OpenFem(true);
                OpenMasc(false);
                break;
            case 2:
                OpenFem(false);
                OpenMasc(true);
                break;
            default:
                OpenFem(true);
                OpenMasc(true);
                break;
        }
    }

    private void OpenFem(Boolean f_open){
        if(!f_open) {
            cadfem.setVisibility(View.GONE);
            cadfem.getLayoutParams().height = 0;
        }
        else{
            final float scale = getResources().getDisplayMetrics().density;
            int dpWidthInPx  = (int) (300 * scale);

            cadfem.getLayoutParams().height= dpWidthInPx;
        }
    }

    private void OpenMasc(Boolean m_open){
        if(!m_open) {
            cadmasc.setVisibility(View.GONE);
            cadmasc.getLayoutParams().height = 0;
        }
        else{
            final float scale = getResources().getDisplayMetrics().density;
            int dpWidthInPx  = (int) (300 * scale);

            cadmasc.getLayoutParams().height= dpWidthInPx;
        }
    }

    private void CheckDados(){
        if(nome == "" || nome == "Nome"){
            openBemVindo();
        }
        else{
            txt_nome.setText(nome);
            txt_data_nasc.setText(data_nasc);
            txt_enderec.setText(enderec);
            txt_responsavel_nome.setText(responsavel_nome);
            txt_responsavel_tel.setText(responsavel_tel);
            txt_saude.setText(saude);
        }
    }

    private void openBemVindo(){
        Intent intent = new Intent(this, welcome.class);
        startActivity(intent);
    }

    private void openSettings(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    private void OpenScene_Introducao(){
        Intent intent = new Intent(this, geral_adolescencia_1.class);
        startActivity(intent);
    }

    private void OpenScene_ECA(){
        Intent intent = new Intent(this, geral_dicassaude.class);
        startActivity(intent);
    }

    private void OpenScene_Saude(){
        Intent intent = new Intent(this, geral_eca.class);
        startActivity(intent);
    }

    private void OpenScene_Alimentacao(){
        Intent intent = new Intent(this, geral_alimentacao.class);
        startActivity(intent);
    }

    private void OpenScene_HigieneBucal(){
        Intent intent = new Intent(this, geral_higienebucal_1.class);
        startActivity(intent);
    }

    private void OpenScene_VacinaMasc(){
        Intent intent = new Intent(this, geral_masc_vacina.class);
        startActivity(intent);
    }

    private void OpenScene_VacinaFem(){
        Intent intent = new Intent(this, geral_fem_vacina.class);
        startActivity(intent);
    }

    private void OpenScene_PuberdadeMasc(){
        Intent intent = new Intent(this, geral_masc_puberdade.class);
        startActivity(intent);
    }

    private void OpenScene_PuberdadeFem(){
        Intent intent = new Intent(this, geral_fem_puberbade.class);
        startActivity(intent);
    }

    private void OpenScene_SexualidadeFem(){
        Intent intent = new Intent(this, geral_fem_sexualidade.class);
        startActivity(intent);
    }

    private void OpenScene_SexualidadeMasc(){
        Intent intent = new Intent(this, geral_fem_sexualidade.class);
        startActivity(intent);
    }

    private void OpenScene_ProjVida(){
        Intent intent = new Intent(this, geral_projvida.class);
        startActivity(intent);
    }

    public void openLibras() {
        if(IsOpen){
            IsOpen = false;
            button_id_1_f.setBackgroundResource(R.drawable.lib_introducao);
            button_id_1_f.setText("");
            button_id_2_f.setBackgroundResource(R.drawable.lib_politica);
            button_id_2_f.setText("");
            button_id_3_f.setBackgroundResource(R.drawable.lib_saude);
            button_id_3_f.setText("");
            button_id_4_f.setBackgroundResource(R.drawable.lib_alimentacao);
            button_id_4_f.setText("");
            button_id_5_f.setBackgroundResource(R.drawable.lib_bucal);
            button_id_5_f.setText("");
            button_id_6_f.setBackgroundResource(R.drawable.lib_vacina);
            button_id_6_f.setText("");
            button_id_7_f.setBackgroundResource(R.drawable.lib_juventude);
            button_id_7_f.setText("");
            button_id_8_f.setBackgroundResource(R.drawable.lib_sexualidade);
            button_id_8_f.setText("");
            button_id_9_f.setBackgroundResource(R.drawable.lib_futuro);
            button_id_9_f.setText("");

            button_id_1_m.setBackgroundResource(R.drawable.lib_introducao);
            button_id_1_m.setText("");
            button_id_2_m.setBackgroundResource(R.drawable.lib_politica);
            button_id_2_m.setText("");
            button_id_3_m.setBackgroundResource(R.drawable.lib_saude);
            button_id_3_m.setText("");
            button_id_4_m.setBackgroundResource(R.drawable.lib_alimentacao);
            button_id_4_m.setText("");
            button_id_5_m.setBackgroundResource(R.drawable.lib_bucal);
            button_id_5_m.setText("");
            button_id_6_m.setBackgroundResource(R.drawable.lib_vacina);
            button_id_6_m.setText("");
            button_id_7_m.setBackgroundResource(R.drawable.lib_juventude);
            button_id_7_m.setText("");
            button_id_8_m.setBackgroundResource(R.drawable.lib_sexualidade);
            button_id_8_m.setText("");
            button_id_9_m.setBackgroundResource(R.drawable.lib_futuro);
            button_id_9_m.setText("");

        }
        else{
            IsOpen = true;
            button_id_1_f.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_1_f.setText("INTRODUÇÃO");
            button_id_2_f.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_2_f.setText("E.C.A.");
            button_id_3_f.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_3_f.setText("DICAS DE SAÚDE");
            button_id_4_f.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_4_f.setText("ALIMENTAÇÃO");
            button_id_5_f.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_5_f.setText("HIGIENE BUCAL");
            button_id_6_f.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_6_f.setText("IMUNIZAÇÃO E VACINAS");
            button_id_7_f.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_7_f.setText("PUBERDADE");
            button_id_8_f.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_8_f.setText("SEXUALIDADE");
            button_id_9_f.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_9_f.setText("PROJETO DE VIDA");

            button_id_1_m.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_1_m.setText("INTRODUÇÃO");
            button_id_2_m.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_2_m.setText("E.C.A.");
            button_id_3_m.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_3_m.setText("DICAS DE SAÚDE");
            button_id_4_m.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_4_m.setText("ALIMENTAÇÃO");
            button_id_5_m.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_5_m.setText("HIGIENE BUCAL");
            button_id_6_m.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_6_m.setText("IMUNIZAÇÃO E VACINAS");
            button_id_7_m.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_7_m.setText("PUBERDADE");
            button_id_8_m.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_8_m.setText("SEXUALIDADE");
            button_id_9_m.setBackgroundResource(android.R.drawable.btn_default_small);
            button_id_9_m.setText("PROJETO DE VIDA");
        }
    }

    private void openSobre(){
        Intent intent = new Intent(this, sobre.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

                case R.id.action_libras:
                    openLibras();
                    return true;

            case R.id.action_help:
                openSobre();
                //Toast.makeText(getBaseContext(),R.string.texto_help, Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
