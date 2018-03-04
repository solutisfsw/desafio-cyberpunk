package com.example.nero.clones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nero.clones.model.Clone;
import com.example.nero.clones.validador.Validador;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class AdicionarClone extends AppCompatActivity {

    private final String TAG = "AdicionarClone";
    private CheckBox bracoMec;
    private CheckBox esqueletoRef;
    private CheckBox sentidosAgu;
    private CheckBox peleAdap;
    private CheckBox raioLaser;

    private EditText nome;
    private EditText idade;
    private List<String> adicionais = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_clone);

        nome = findViewById(R.id.input_name_clone);
        idade = findViewById(R.id.input_idade_clone);

        bracoMec = findViewById(R.id.ch_braco_mec);
        esqueletoRef = findViewById(R.id.ch_esqueleto_ref);
        sentidosAgu = findViewById(R.id.ch_sentidos_agu);
        peleAdap = findViewById(R.id.ch_pele_adap);
        raioLaser = findViewById(R.id.ch_raio_laser);

        Button button = findViewById(R.id.btn_cadastrar_clone);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = nome.getText().toString().toUpperCase();
                int i = Integer.parseInt(idade.getText().toString());
                if(Validador.validarNome(n) && Validador.validarIdade(i)== true){
                    verificaCheckBox();
                    Clone clone = new Clone();
                    clone.setNome(n);
                    clone.setIdade(i);
                    clone.setDataCriacao(getDataSistema());
                    clone.setAdicionais(adicionais);
                    clear();
                    enviarServidor(clone);
                }else {
                    TextView alertNome = (TextView) findViewById(R.id.alert_nome);
                    TextView alertIdade = (TextView) findViewById(R.id.alert_idade);
                    alertNome.setVisibility(View.VISIBLE);
                    alertIdade.setVisibility(View.VISIBLE);
                    Toast.makeText(getBaseContext(), "Favor, verifique os campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void verificaCheckBox(){
        if(bracoMec.isChecked()) adicionais.add("Braço Mecânico");
        if(esqueletoRef.isChecked()) adicionais.add("Esqueleto Reforçado");
        if(sentidosAgu.isChecked()) adicionais.add("Sentidos Aguçados");
        if(peleAdap.isChecked()) adicionais.add("Pele Adaptativa");
        if(raioLaser.isChecked()) adicionais.add("Raio Laser");
    }

    private void clear(){
        nome.setText("");
        idade.setText("");
    }

    private String getDataSistema(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = simpleDateFormat.format(date);
        return dataFormatada;
    }

    private void enviarServidor(Clone clone){
        final AsyncHttpClient client = new AsyncHttpClient();
        try {
            Gson gson = new Gson();
            String json = gson.toJson(clone);
            StringEntity entity = new StringEntity(json, "UTF-8");
            Log.d(TAG, json);
            String url = "http://192.168.1.102:8080/clones";
            client.post(getBaseContext(),url,entity ,"application/json;charset=UTF-8",new TextHttpResponseHandler() {
                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    Toast.makeText(getBaseContext(), "Falha no cadastro", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, responseString + " // "+throwable.getMessage());
                }
                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    Toast.makeText(getBaseContext(), "Clone cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
