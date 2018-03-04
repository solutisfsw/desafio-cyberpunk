package com.example.nero.clones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.nero.clones.adapter.CloneAdapter;
import com.example.nero.clones.model.Clone;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ListClones extends AppCompatActivity {

    private final String TAG ="ListClones";
    private ListView listView;
    private ArrayList<Clone> listaClones;
    private CloneAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_clones);

        listaClones = new ArrayList<>();
        listView = findViewById(R.id.list_clones);
        adapter = new CloneAdapter(this, listaClones);
        listView.setAdapter(adapter);
        progressBar = findViewById(R.id.progressbar);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>  adapterView, View view, int position, long l) {
                Clone clone = (Clone) adapterView.getItemAtPosition(position);
                Toast.makeText(getBaseContext(), clone.getNome(), Toast.LENGTH_LONG).show();
            }
        });
        enviarServidor();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.clear();
        enviarServidor();
    }

    private void enviarServidor(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://192.168.1.102:8080/clones";
        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d(TAG,"Erro ao carregar lista de clones: "+responseString);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d(TAG,"SUCESSO: "+responseString);
                Gson gson = new Gson();
                Clone[] clones = gson.fromJson(responseString, Clone[].class);
                for(Clone clone: clones){
                    adapter.add(clone);
                }
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}
