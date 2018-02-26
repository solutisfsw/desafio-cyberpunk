package br.com.luisferreira.desafio_cyberpunk.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.luisferreira.desafio_cyberpunk.model.Clone;
import br.com.luisferreira.desafio_cyberpunk.R;

/**
 * Created by Luis Ferreira on 25/02/2018.
 */

public class InsertActivity extends AppCompatActivity implements View.OnClickListener {

    private Clone clone;

    private AutoCompleteTextView textNomeClone;
    private AutoCompleteTextView textIdadeClone;
    private AutoCompleteTextView textDataCriacao;

    private FloatingActionButton fabEnviarDadosCadastro;

    protected ProgressBar progressBar;

    private DatabaseReference databaseReference;

    private Pattern pattern;
    private Matcher matcher;

    private static final String NOME_PATTERN = "[A-Z]{3}[0-9]{4}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cadastro de Clones");

        pattern = Pattern.compile(NOME_PATTERN);

        fabEnviarDadosCadastro = findViewById(R.id.fabEnviarDadosCadastro);
        fabEnviarDadosCadastro.setOnClickListener(this);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        initViews();
    }

    private void initViews() {
        textNomeClone = findViewById(R.id.textNomeClone);
        textIdadeClone = findViewById(R.id.textIdadeClone);
        textDataCriacao = findViewById(R.id.textDataCriacao);
        progressBar = findViewById(R.id.sign_up_progress);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        textDataCriacao.setText(simpleDateFormat.format(new Date()));
        textDataCriacao.setEnabled(false);
    }

    protected void initUsuario() {
        clone = new Clone();
        clone.setNome(textNomeClone.getText().toString().trim());

        String idade = textIdadeClone.getText().toString();

        if (!idade.isEmpty()) {
            clone.setIdade(Long.parseLong(idade));
        }

        clone.setDataCriacao(textDataCriacao.getText().toString());
    }

    @Override
    public void onClick(View v) {
        initUsuario();

        String nome = textNomeClone.getText().toString().trim();
        String idade = textIdadeClone.getText().toString();

        matcher = pattern.matcher(nome);

        boolean ok = true;

        if (nome.isEmpty()) {
            textNomeClone.setError(getString(R.string.msg_erro_nome_empty));
            ok = false;
        } else {
            if (!matcher.matches()) {
                textNomeClone.setError(getString(R.string.msg_erro_nome_pattern));
                ok = false;
            } /*else {
                Query query = databaseReference.child("clones").orderByChild("nome").equalTo(nome);

                if (query != null) {
                    textNomeClone.setError(getString(R.string.msg_erro_nome_exist));
                    ok = false;
                }
            }*/
        }

        if (idade.isEmpty()) {
            textIdadeClone.setError(getString(R.string.msg_erro_idade_empty));
            ok = false;
        } else {
            Long nIdade = Long.parseLong(idade);

            if (nIdade < 10 || nIdade > 20) {
                textIdadeClone.setError(getString(R.string.msg_erro_idade_invalida));
                ok = false;
            }
        }

        if (ok) {
            fabEnviarDadosCadastro.setEnabled(false);

            openProgressBar();

            databaseReference.child("clones").push().setValue(clone);

            showToast("Clone cadastrado com sucesso!");

            closeProgressBar();

            finish();
        } else {
            closeProgressBar();
            textNomeClone.setFocusable(true);
            fabEnviarDadosCadastro.setEnabled(true);
        }
    }

    protected void openProgressBar() {
        progressBar.setFocusable(true);
        progressBar.setVisibility(View.VISIBLE);
    }

    protected void closeProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    protected void showToast(String message) {
        Toast.makeText(this,
                message,
                Toast.LENGTH_LONG)
                .show();
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