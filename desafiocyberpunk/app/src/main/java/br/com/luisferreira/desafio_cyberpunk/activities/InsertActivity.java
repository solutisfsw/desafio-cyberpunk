package br.com.luisferreira.desafio_cyberpunk.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.luisferreira.desafio_cyberpunk.model.Clone;
import br.com.luisferreira.desafio_cyberpunk.R;

public class InsertActivity extends AppCompatActivity implements View.OnClickListener {

    private Clone clone;

    private AutoCompleteTextView textNomeClone;
    private AutoCompleteTextView textIdadeClone;
    private AutoCompleteTextView textDataCriacao;

    private FloatingActionButton fabEnviarDadosCadastro;

    protected ProgressBar progressBar;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cadastro de Clones");

        initViews();

        fabEnviarDadosCadastro = findViewById(R.id.fabEnviarDadosCadastro);
        fabEnviarDadosCadastro.setOnClickListener(this);

        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    private void initViews() {
        textNomeClone = findViewById(R.id.textNomeClone);
        textIdadeClone = findViewById(R.id.textIdadeClone);
        textDataCriacao = findViewById(R.id.textDataCriacao);
        progressBar = findViewById(R.id.sign_up_progress);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        textDataCriacao.setText(simpleDateFormat.format(new Date()));
    }

    protected void initUsuario() {
        clone = new Clone();
        clone.setNome(textNomeClone.getText().toString());
        clone.setIdade(Long.parseLong(textIdadeClone.getText().toString()));
        clone.setDataCriacao(textDataCriacao.getText().toString());
    }

    @Override
    public void onClick(View v) {
        initUsuario();

        databaseReference.child("clones").push().setValue(clone);

        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}