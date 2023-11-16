package com.cadsaude.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Settings {

    private Button btn_apply;
    private EditText ed_nome;
    private EditText ed_enderec;

    private EditText ed_data_nasc_dia;
    private EditText ed_data_nasc_mes;
    private EditText ed_data_nasc_ano;

    private EditText ed_responsavel_nome;
    private EditText ed_responsavel_tel;
    private EditText ed_saude;
    private Toolbar myToolbar;

    public static final String PREFS_NAME = "PerfilFile";

    private String nome = "null";
    private int data_nasc_dia;
    private int data_nasc_mes;
    private int data_nasc_ano;
    private String enderec = "null";
    private String responsavel_nome = "null";
    private String responsavel_tel = "null";
    private String saude = "null";
    private int opcoes = 1;

    private RadioButton rb_masc;
    private RadioButton rb_fem;
    private RadioButton rb_both;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btn_apply = findViewById(R.id.button_apply);
        ed_nome = findViewById(R.id.editText_Nome);
        ed_enderec = findViewById(R.id.editText_End);
        ed_data_nasc_dia = findViewById(R.id.editText_Nasc_dia);
        ed_data_nasc_mes = findViewById(R.id.editText_Nasc_mes);
        ed_data_nasc_ano = findViewById(R.id.editText_Nasc_ano);

        ed_responsavel_nome = findViewById(R.id.editText_NomeRes);
        ed_responsavel_tel = findViewById(R.id.editText_TelRes);

        ed_saude = findViewById(R.id.editText_Sau);

        rb_masc = findViewById(R.id.radio_masc);
        rb_fem = findViewById(R.id.radio_fem);
        rb_both = findViewById(R.id.radio_both);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setBackgroundColor(Color.parseColor("#C8FFC8"));
        setSupportActionBar(myToolbar);

        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfereDados();
            }
        });
        GetInfoPerfil();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_fem:
                if (checked)
                    opcoes = 1;
                    break;
            case R.id.radio_masc:
                if (checked)
                    opcoes = 2;
                    break;
            case R.id.radio_both:
                if (checked)
                    opcoes = 0;
                break;
        }
    }

    private void GetInfoPerfil(){
        //coleta infos armazenadas
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String verNome = settings.getString("nome","");

        if(verNome != "") {
            ed_nome.setText(settings.getString("nome", ""));
            ed_data_nasc_dia.setText(String.valueOf(settings.getInt("data_nasc_dia", 0)));
            ed_data_nasc_mes.setText(String.valueOf(settings.getInt("data_nasc_mes", 0)));
            ed_data_nasc_ano.setText(String.valueOf(settings.getInt("data_nasc_ano", 0)));
            ed_enderec.setText(settings.getString("enderec", ""));
            ed_responsavel_nome.setText(settings.getString("responsavel_nome", ""));
            ed_responsavel_tel.setText(settings.getString("responsavel_tel", ""));
            ed_saude.setText(settings.getString("saude", ""));
            opcoes = settings.getInt("opcoes", 1);

            if(opcoes == 1){
                rb_fem.setChecked(true);
            }
            else if(opcoes == 2){
                rb_masc.setChecked((true));
            }
            else{
                rb_both.setChecked((true));
            }
        }
        else{
            //setar um check válido pra caderneta opções pra não deixar em branco as 3 opções
            opcoes = 1;
            rb_fem.setChecked(true);
        }
    }

    private void ConfereDados(){
        nome = ed_nome.getText().toString();

        enderec = ed_enderec.getText().toString();

        String sDia = ed_data_nasc_dia.getText().toString();
        int iDia = Integer.parseInt(sDia);
        String sMes = ed_data_nasc_mes.getText().toString();
        int iMes = Integer.parseInt(sMes);
        String sAno = ed_data_nasc_ano.getText().toString();
        int iAno = Integer.parseInt(sAno);

        boolean isBissexto = AnoBissexto(iAno);
        boolean dataValida = CheckData(iDia, iMes, iAno, isBissexto);

        responsavel_nome = ed_responsavel_nome.getText().toString();
        responsavel_tel = ed_responsavel_tel.getText().toString();
        saude = ed_saude.getText().toString();


        if(nome.length() <= 0){
            MensagemDados("Nome");
        }
        else if(enderec.length() <= 0){
            MensagemDados("Endereço");
        }
        else if(!dataValida){
            MensagemDados("Data de nascimento");
        }
        else{
            SetDados();
        }
    }

    private boolean CheckData(int Dia, int Mes, int Ano, boolean Bissexto){
        //dia menor que 1
        //dia maior que 31
        //dia maior que 28 com mes 2 em ano não-bissexto
        //dia maior que 29 com mes 2
        //mes menor que 1
        //mes maior que 12
        //ano menor que 1900
        boolean isCerto = false;
        if(Dia<1 || Dia>31 || Dia>28 && Mes == 2 && !Bissexto || Mes == 2 && Dia > 29 || Mes < 1 || Mes > 12 || Ano < 1900){
            isCerto = false;
        }
        else{
            isCerto = true;
            data_nasc_ano = Ano;
            data_nasc_mes = Mes;
            data_nasc_dia = Dia;
        }
        return isCerto;
    }

    private boolean AnoBissexto(int ano){

        boolean isBis = ano%4 == 0 ? true : false;
        return isBis;
    }

    private void MensagemDados(String dado){
        Toast.makeText(getBaseContext(),"Insira um dado válido: "+dado, Toast.LENGTH_SHORT).show();
    }

    private void SetDados(){
        Toast.makeText(getBaseContext(),"Dados Salvos com Sucesso", Toast.LENGTH_SHORT).show();
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("nome", nome);
        editor.putString("enderec", enderec);
        editor.putInt("data_nasc_dia", data_nasc_dia);
        editor.putInt("data_nasc_mes", data_nasc_mes);
        editor.putInt("data_nasc_ano", data_nasc_ano);
        editor.putString("responsavel_nome", responsavel_nome);
        editor.putString("responsavel_tel", responsavel_tel);
        editor.putString("saude", saude);
        editor.putInt("opcoes",opcoes);

        // Commit as edições
        editor.commit();
        OpenMenu();
    }

    public void OpenMenu(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_help:
                Toast.makeText(getBaseContext(),R.string.texto_help, Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}