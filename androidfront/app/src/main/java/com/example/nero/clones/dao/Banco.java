package com.example.nero.clones.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nero on 03/03/2018.
 */

public class Banco extends SQLiteOpenHelper {

    private final static int VERSAO = 1;
    private static final String NOME = "BANCO_CLONES";
    private static final String TABELA_CLONES = "TABELA_CLONES";
    private static final String TABELA_ADICIONAIS = "TABELA_ADICIONAIS";


    public Banco(Context context) {
        super(context, NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABELA_CLONES+"(" +
                "id integer primary key, " +
                "nome text not null," +
                "idade integer not null, " +
                "datacriacao text not null" +
                ")");

        db.execSQL("create table "+TABELA_ADICIONAIS+"(" +
                "id integer primary key autoincrement, " +
                "nome text not null," +
                "id_clone int not null," +
                "foreign key (id_clone) references tabela_clones(id)"+
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABELA_CLONES);
        db.execSQL("DROP TABLE IF EXISTS "+TABELA_ADICIONAIS);
        onCreate(db);
    }
}
