package br.com.luisferreira.desafio_cyberpunk.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.luisferreira.desafio_cyberpunk.model.Clone;
import br.com.luisferreira.desafio_cyberpunk.R;

/**
 * Created by Luis Ferreira on 25/02/2018.
 */

public class InsertActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText textNomeClone;
    private EditText textIdadeClone;
    private EditText textDataCriacao;
    private Toolbar toolbar;
    private Button btnCadastrar;
    private CheckBox chkBracoMecanico;
    private CheckBox chkEsqueletoReforcado;
    private CheckBox chkSentidosAgucados;
    private CheckBox chkPeleAdaptativa;
    private CheckBox chkRaioLaser;
    protected ProgressBar progressBar;

    private DatabaseReference databaseReference;
    private Pattern pattern;
    private Matcher matcher;
    private Clone clone;
    private List<String> adicionais = new ArrayList<>();
    private static final String NOME_PATTERN = "[A-Z]{3}[0-9]{4}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cadastro de Clones");

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(this);

        pattern = Pattern.compile(NOME_PATTERN);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        initViews();
    }

    private void initViews() {
        textNomeClone = findViewById(R.id.textNomeClone);
        textIdadeClone = findViewById(R.id.textIdadeClone);
        textDataCriacao = findViewById(R.id.textDataCriacao);
        progressBar = findViewById(R.id.sign_up_progress);

        chkBracoMecanico = findViewById(R.id.chkBracoMecanico);
        chkEsqueletoReforcado = findViewById(R.id.chkEsqueletoReforcado);
        chkSentidosAgucados = findViewById(R.id.chkSentidosAgucados);
        chkPeleAdaptativa = findViewById(R.id.chkPeleAdaptativa);
        chkRaioLaser = findViewById(R.id.chkRaioLaser);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        textDataCriacao.setText(simpleDateFormat.format(new Date()));
        textDataCriacao.setEnabled(false);
    }

    protected void initClone() {
        clone = new Clone();

        clone.setNome(textNomeClone.getText().toString().trim());

        String idade = textIdadeClone.getText().toString();
        if (!idade.isEmpty()) {
            clone.setIdade(Long.parseLong(idade));
        }

        if (chkBracoMecanico.isChecked()) {
            adicionais.add("Braço Mecânico");
        }

        if (chkEsqueletoReforcado.isChecked()) {
            adicionais.add("Esqueleto Reforçado");
        }

        if (chkSentidosAgucados.isChecked()) {
            adicionais.add("Sentidos Aguçados");
        }

        if (chkPeleAdaptativa.isChecked()) {
            adicionais.add("Pele Adaptativa");
        }

        if (chkRaioLaser.isChecked()) {
            adicionais.add("Raio Laser");
        }

        clone.setDataCriacao(textDataCriacao.getText().toString());
        clone.setAdicionais(adicionais);
    }

    @Override
    public void onClick(View v) {
        initClone();

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
            }
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
            btnCadastrar.setEnabled(false);

            openProgressBar();

            Query query = databaseReference.child("clones").orderByChild("nome").equalTo(nome);
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue() != null) {
                        textNomeClone.setError(getString(R.string.msg_erro_nome_exist));

                        adicionais.clear();

                        btnCadastrar.setEnabled(true);
                    } else {
                        databaseReference.child("clones").push().setValue(clone);

                        showToast("Clone cadastrado com sucesso!");

                        finish();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            closeProgressBar();
        } else {
            adicionais.clear();
            closeProgressBar();
            btnCadastrar.setEnabled(true);
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