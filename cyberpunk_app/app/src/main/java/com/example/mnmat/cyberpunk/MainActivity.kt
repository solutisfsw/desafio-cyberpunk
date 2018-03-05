package com.example.mnmat.cyberpunk

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import com.example.mnmat.cyberpunk.models.Clone
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.R.string.cancel
import android.app.AlertDialog
import android.content.DialogInterface
import android.text.InputType
import android.support.v4.widget.SearchViewCompat.setInputType
import android.widget.EditText



class MainActivity : AppCompatActivity() {

    var listaClone = ArrayList<Clone>();
    var customAdapter: ClonesListAdapter? = null
    var requestContr : RequestController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestContr = RequestController(this)
        setContentView(R.layout.activity_main)

        fabAdd.setOnClickListener {
            val intent = Intent(this, Details::class.java);
            startActivityForResult(intent, REQUEST_CRIAR);
        }
        solicitar_ip();
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && intArrayOf(REQUEST_CRIAR, REQUEST_EDITAR).contains(requestCode)) {
            atualiza_lista();
        }
    }

    public fun atualiza_lista(){
        requestContr?.get_clones(this);
    }

    public fun recebe_nova_lista(clonesAtualizados : ArrayList<Clone>){
        listaClone = clonesAtualizados;
        customAdapter = ClonesListAdapter(this, R.layout.item_clone, listaClone)
        lista_clones .setAdapter(customAdapter)
    }

    public fun remove_clone(id: Int){
        requestContr?.remove_clone(this, id)
    }

    fun solicitar_ip(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Deseja definir o endereço manualmente? (Ex.: 127.0.0.1)")

        val input = EditText(this)
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which -> requestContr?.mudar_addr(input.text.toString()); atualiza_lista(); })
        builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, which -> dialog.cancel(); atualiza_lista(); })

        builder.show()
    }

    companion object {
        val REQUEST_CRIAR = 0
        val REQUEST_EDITAR = 1
    }
}


