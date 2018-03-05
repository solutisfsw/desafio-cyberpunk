package com.example.mnmat.cyberpunk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mnmat.cyberpunk.models.Clone
import kotlinx.android.synthetic.main.activity_details.*
import android.widget.EditText
import java.util.regex.Pattern


class Details : AppCompatActivity() {

    var id: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if( intent.hasExtra(CLONE_STR)) {
            val clone = intent?.getSerializableExtra(CLONE_STR) as Clone
            if (clone != null) {
                id = clone.id
                nome_input.setText(clone.nome)
                idade_input.setText(clone.idade.toString())
                braco_check.isChecked = clone.braco_mecanico
                esqueleto_check.isChecked = clone.esqueleto_reforcado
                pele_check.isChecked = clone.pele_adaptativa
                sentidos_check.isChecked = clone.sentidos_agucados
                raio_check.isChecked = clone.raio_laser
            }
        }

        salvarClone.setOnClickListener {
            //Testando a validade das entradas
            if(isValid(nome_input, NOME_REGEX, getString(R.string.text_nome_invalido)) && isValid(idade_input, IDADE_REGEX, getString(R.string.text_idade_invalida))) {
                val clone = Clone(nome_input.text.toString(), Integer.parseInt(idade_input.text.toString()),
                        braco_check.isChecked, esqueleto_check.isChecked, sentidos_check.isChecked, pele_check.isChecked, raio_check.isChecked)

                val requestCtr = RequestController(this);
                if (id != null) {
                    clone.id = id as Int
                    requestCtr.editar_clone(this, clone);
                } else {
                    requestCtr.adicionar_clone(this, clone);
                }
            }
        }
    }

    fun isValid(editText: EditText, regex: String, errMsg: String): Boolean {

        val text = editText.text.toString().trim { it <= ' ' }
        editText.error = null

        // Caso o campo esteja em branco
        if (text == "")
        {
            editText.error = getString(R.string.text_campo_vazio);
            return false
        }

        // caso não seja aceito pela REGEX
        if (!Pattern.matches(regex, text)) {
            editText.error = errMsg
            return false
        }

        return true
    }

     fun clone_criado(){
        val intent = Intent()
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    fun erro_nome_repetido(){
        nome_input.error = "Nome já cadstrado!"
    }

    companion object {
        val CLONE_STR = "clone";
        val NOME_REGEX = "^[A-Z]{3}[0-9]{4}$"
        val IDADE_REGEX = "^20|1[0-9]"
    }

}
