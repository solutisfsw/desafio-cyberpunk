package com.example.nero.clones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
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

public class AlterarClone extends AppCompatActivity {

    private final String TAG = "AlterarClone";

    private CheckBox bracoMec;
    private CheckBox esqueletoRef;
    private CheckBox sentidosAgu;
    private CheckBox peleAdap;
    private CheckBox raioLaser;

    private EditText nome;
    private EditText idade;

    private Button alterar;
    private List<String> adicionais = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_clone);
        Intent intent = getIntent();
        final Clone clone = (Clone) intent.getSerializableExtra("clone");
        adicionais = (ArrayList<String>) intent.getSerializableExtra("adicionais");

        nome = findViewById(R.id.input_name_clone_alterar);
        idade = findViewById(R.id.input_idade_clone_alterar);

        bracoMec = findViewById(R.id.ch_braco_mec_alterar);
        esqueletoRef = findViewById(R.id.ch_esqueleto_ref_alterar);
        sentidosAgu = findViewById(R.id.ch_sentidos_agu_alterar);
        peleAdap = findViewById(R.id.ch_pele_adap_alterar);
        raioLaser = findViewById(R.id.ch_raio_laser_alterar);

        alterar = findViewById(R.id.btn_cadastrar_clone_alterar);

        nome.setText(clone.getNome());
        idade.setText(clone.getIdade().toString());

        contemCheckBox();

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeClone = nome.getText().toString();
                int idadeClone = Integer.parseInt(idade.getText().toString());
                verificaCheckBox();

                clone.setNome(nomeClone);
                clone.setIdade(idadeClone);
                clone.setAdicionais(adicionais);

                final AsyncHttpClient client = new AsyncHttpClient();
                try {
                    Gson gson = new Gson();
                    String json = gson.toJson(clone);
                    String id = clone.getId().toString();
                    StringEntity entity = new StringEntity(json, "UTF-8");
                    Log.d(TAG, json);
                    client.put(getBaseContext(),"http://192.168.0.3:8080/clones/"+id,entity ,"application/json;charset=UTF-8",new TextHttpResponseHandler() {
                        @Override
                        public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                            Toast.makeText(getBaseContext(), "Falha ao alterar", Toast.LENGTH_SHORT).show();
                            Log.i(TAG, responseString + " // "+throwable.getMessage());
                        }
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, String responseString) {
                            Toast.makeText(getBaseContext(), "Clone alterado com sucesso", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }

    private void verificaCheckBox(){
        adicionais.clear();
        if(bracoMec.isChecked()) adicionais.add("Braço Mecânico");
        if(esqueletoRef.isChecked()) adicionais.add("Esqueleto Reforçado");
        if(sentidosAgu.isChecked()) adicionais.add("Sentidos Aguçados");
        if(peleAdap.isChecked()) adicionais.add("Pele Adaptativa");
        if(raioLaser.isChecked()) adicionais.add("Raio Laser");
    }

    private void contemCheckBox(){
        if(adicionais.contains("Braço Mecânico")) bracoMec.setChecked(true);
        if(adicionais.contains("Esqueleto Reforçado")) esqueletoRef.setChecked(true);
        if(adicionais.contains("Sentidos Aguçados")) sentidosAgu.setChecked(true);
        if(adicionais.contains("Pele Adaptativa")) peleAdap.setChecked(true);
        if(adicionais.contains("Raio Laser")) raioLaser.setChecked(true);
    }


}
