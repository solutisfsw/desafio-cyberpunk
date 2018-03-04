package br.com.luisferreira.desafio_cyberpunk.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.luisferreira.desafio_cyberpunk.R;
import br.com.luisferreira.desafio_cyberpunk.model.Clone;

/**
 * Created by Luis Ferreira on 04/03/2018.
 */

public class CloneActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AddCloneActivity";

    private EditText textNomeClone;
    private EditText textIdadeClone;
    private Toolbar toolbar;
    private Button btnEditarCadastrar;
    private CheckBox chkBracoMecanico;
    private CheckBox chkEsqueletoReforcado;
    private CheckBox chkSentidosAgucados;
    private CheckBox chkPeleAdaptativa;
    private CheckBox chkRaioLaser;
    protected ProgressBar progressBar;

    private Pattern pattern;
    private Matcher matcher;
    private Clone clone;
    private List<String> adicionais = new ArrayList<>();
    private static final String NOME_PATTERN = "[A-Z]{3}[0-9]{4}";

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private FirebaseFirestore firebaseFirestore;

    boolean isUpdating;
    String id;
    String nomeClone;
    String idadeClone;
    String adicionaisClone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clone);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        isUpdating = getIntent().getBooleanExtra("isUpdating", false);
        btnEditarCadastrar = findViewById(R.id.btnEditarCadastrar);

        if (isUpdating) {
            getSupportActionBar().setTitle("Editar Clone");
            btnEditarCadastrar.setText("Salvar");

            id = getIntent().getStringExtra("idClone");
        } else {
            getSupportActionBar().setTitle("Cadastrado de Clones");
            btnEditarCadastrar.setText("Cadastrar");
        }

        firebaseFirestore = FirebaseFirestore.getInstance();

        btnEditarCadastrar.setOnClickListener(this);

        pattern = Pattern.compile(NOME_PATTERN);

        initViews();
    }

    private void initViews() {
        textNomeClone = findViewById(R.id.textNomeClone);
        textIdadeClone = findViewById(R.id.textIdadeClone);
        chkBracoMecanico = findViewById(R.id.chkBracoMecanico);
        chkEsqueletoReforcado = findViewById(R.id.chkEsqueletoReforcado);
        chkSentidosAgucados = findViewById(R.id.chkSentidosAgucados);
        chkPeleAdaptativa = findViewById(R.id.chkPeleAdaptativa);
        chkRaioLaser = findViewById(R.id.chkRaioLaser);

        progressBar = findViewById(R.id.sign_up_progress);

        if (isUpdating) {
            nomeClone = getIntent().getStringExtra("textViewNomeClone");
            idadeClone = getIntent().getStringExtra("textViewIdadeClone");
            adicionaisClone = getIntent().getStringExtra("textViewAdicionais");

            textNomeClone.setText(nomeClone);
            textNomeClone.setSelection(textNomeClone.getText().length());
            textIdadeClone.setText(idadeClone);

            if(adicionaisClone.contains("Braço Mecânico")) {
                chkBracoMecanico.setChecked(true);
            }

            if(adicionaisClone.contains("Esqueleto Reforçado")) {
                chkEsqueletoReforcado.setChecked(true);
            }

            if(adicionaisClone.contains("Sentidos Aguçados")) {
                chkSentidosAgucados.setChecked(true);
            }

            if(adicionaisClone.contains("Pele Adaptativa")) {
                chkPeleAdaptativa.setChecked(true);
            }

            if(adicionaisClone.contains("Raio Laser")) {
                chkRaioLaser.setChecked(true);
            }
        }
    }

    protected void initClone() {
        clone = new Clone();

        clone.setNome(textNomeClone.getText().toString().trim());
        String idade = textIdadeClone.getText().toString();

        if (!idade.isEmpty()) {
            clone.setIdade(Integer.parseInt(idade));
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

        clone.setDataCriacao(simpleDateFormat.format(new Date()));
        clone.setAdicionais(adicionais);
    }

    @Override
    public void onClick(View v) {
        initClone();

        final String nome = textNomeClone.getText().toString().trim();
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
            int nIdade = Integer.parseInt(idade);

            if (nIdade < 10 || nIdade > 20) {
                textIdadeClone.setError(getString(R.string.msg_erro_idade_invalida));
                ok = false;
            }
        }

        if (ok) {
            btnEditarCadastrar.setEnabled(false);

            openProgressBar();

            if (isUpdating) {
                updateClone(id, clone.getNome(), (int) clone.getIdade(), clone.getDataCriacao(), clone.getAdicionais());
            } else {

                /*firebaseFirestore.collection("clones")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (DocumentSnapshot document : task.getResult()) {
                                        if (document.getData().toString().contains(nome)) {
                                            textNomeClone.setError(getString(R.string.msg_erro_nome_exist));
                                            Log.d(TAG, document.getId() + " => " + document.getData());
                                            Toast.makeText(InsertActivity.this, document.getId() + " => " + document.getData(),
                                                    Toast.LENGTH_SHORT).show();
                                        } else {
                                            addClone(clone.getNome(), (int) clone.getIdade(), clone.getDataCriacao(), clone.getAdicionais());
                                        }
                                    }
                                    btnEditarCadastrar.setEnabled(true);
                                } else {
                                    Log.d(TAG, "Error getting documents: ", task.getException());
                                }
                            }
                        });*/

                addClone(clone.getNome(), (int) clone.getIdade(), clone.getDataCriacao(), clone.getAdicionais());

            }

            closeProgressBar();
        } else {
            adicionais.clear();
            closeProgressBar();
            btnEditarCadastrar.setEnabled(true);
        }
    }

    private void updateClone(String id, String nome, int idade, String dataCriacao, List<String> adicionais) {
        Map<String, Object> cloneMap = (new Clone(id, nome, idade, dataCriacao, adicionais)).toMap();

        firebaseFirestore.collection("clones")
                .document(id)
                .set(cloneMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.e(TAG, "Clone atualizado com sucesso!");

                        showToast("Clone atualizado com sucesso!");

                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "Erro ao atualizar", e);

                        showToast("Não foi possível atualizar o clone!");
                    }
                });
    }

    private void addClone(String nome, int idade, String dataCriacao, List<String> adicionais) {
        Map<String, Object> cloneMap = new Clone(nome, idade, dataCriacao, adicionais).toMap();

        firebaseFirestore.collection("clones")
                .add(cloneMap)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.e(TAG, "Clone adicionado com o ID: " + documentReference.getId());

                        showToast("Clone cadastrado com sucesso!");

                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "Erro ao adicionar", e);

                        showToast("O clone não foi cadastrado!");
                    }
                });
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