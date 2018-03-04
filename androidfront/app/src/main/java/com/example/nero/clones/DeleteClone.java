package com.example.nero.clones;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.nero.clones.model.Clone;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class DeleteClone extends AppCompatActivity {

    private final static String TAG= "DeleteClone";
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_clone);

        progressBar = findViewById(R.id.delete_progressbar);
        Intent intent = getIntent();
        final Long id = intent.getLongExtra("clone", 0);

        enviarServidor(id);
    }

    private void enviarServidor(Long id){
        final AsyncHttpClient client = new AsyncHttpClient();
        try {
            String url = "http://192.168.1.102:8080/clones/"+id;

            client.addHeader("Content-Type","application/json;charset=UTF-8");
            client.delete(getBaseContext(),url, new TextHttpResponseHandler() {
                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    Log.i(TAG, responseString + " // "+throwable.getMessage());
                    progressBar.setVisibility(View.INVISIBLE );
                    AlertDialog.Builder dlg = new AlertDialog.Builder(DeleteClone.this);
                    dlg.setMessage("Ocorreu algum erro ao deletar clone");
                    dlg.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    dlg.show();
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    progressBar.setVisibility(View.INVISIBLE );
                    AlertDialog.Builder dlg = new AlertDialog.Builder(DeleteClone.this);
                    dlg.setMessage("Clone deletado com sucesso");
                    dlg.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    dlg.show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
