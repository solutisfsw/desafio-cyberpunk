package br.com.luisferreira.desafio_cyberpunk.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

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

    private List<Clone> clones = new ArrayList<>();

    private DatabaseReference databaseReference;

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;

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
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerAdapter = new RecyclerAdapter(clones);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.notifyDataSetChanged();
    }

    private void fetchData() {
        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child("clones").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                clones.removeAll(clones);

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Clone clone = snapshot.getValue(Clone.class);
                    clones.add(clone);
                }
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void chamarCadastro() {
        Intent intent = new Intent(this, InsertActivity.class);
        startActivity(intent);
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
            case R.id.action_add:
                chamarCadastro();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
