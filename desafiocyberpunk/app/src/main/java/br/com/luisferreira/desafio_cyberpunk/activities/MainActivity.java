package br.com.luisferreira.desafio_cyberpunk.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.luisferreira.desafio_cyberpunk.R;
import br.com.luisferreira.desafio_cyberpunk.adapter.RecyclerAdapter;
import br.com.luisferreira.desafio_cyberpunk.model.Clone;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private FloatingActionButton fabNovoClone;
    protected ProgressBar progressBar;

    private List<Clone> clones = new ArrayList<>();
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Clones Cadastrados");

        initViews();
        fetchData();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_clones);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new RecyclerAdapter(clones);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        fabNovoClone = findViewById(R.id.fabNovoClone);

        progressBar = findViewById(R.id.main_progress);
    }

    private void fetchData() {
        openProgressBar();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("clones").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                clones.removeAll(clones);

                if (!dataSnapshot.exists()) {
                    showSnackbar("Não existem clones cadastrados!");
                } else {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Clone clone = snapshot.getValue(Clone.class);
                        clones.add(clone);
                    }
                    recyclerAdapter.notifyDataSetChanged();
                }

                closeProgressBar();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                showSnackbar("Não foi possível buscar os dados!");
                closeProgressBar();
            }
        });
    }

    public void chamarCadastro(View view) {
        Intent intent = new Intent(this, InsertActivity.class);
        startActivity(intent);
    }

    protected void openProgressBar() {
        progressBar.setFocusable(true);
        progressBar.setVisibility(View.VISIBLE);
    }

    protected void closeProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    protected void showSnackbar(String message) {
        Snackbar.make(progressBar,
                message,
                Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    // MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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