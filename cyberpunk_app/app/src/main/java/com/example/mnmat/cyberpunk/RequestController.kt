package com.example.mnmat.cyberpunk

import android.app.AlertDialog
import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import com.android.volley.*

import com.android.volley.toolbox.StringRequest
import com.example.mnmat.cyberpunk.models.Clone
import org.json.JSONArray
import java.util.*


/**
 * Created by mnmat on 24/08/2017.
 */

class RequestController(context: Context) {
    internal var response: String? = null
    var addr = "http://10.0.2.2:8080"
    var addr_clones = "$addr/clones"
    var contextmain : Context? = null;

    init {
        addr = PreferenceManager.getDefaultSharedPreferences(context).getString("hostAddr", "http://10.0.2.2:8080")
        addr_clones = "$addr/clones"
        contextmain = context;
    }

    fun get_clones(context: MainActivity) {

        class Call_Listar : Callable() {
            override fun sucesso(response : String) {
                var listaClone = ArrayList<Clone>();

                val mainArray = JSONArray(response)

                var i: Int=0;
                for (i in 0..(mainArray.length() - 1)){
                        val jsonClone = mainArray.getJSONObject(i);
                        val clone = Clone(jsonClone.getString("nome"), jsonClone.getInt("idade"), jsonClone.getBoolean("braco_mecanico"),
                                jsonClone.getBoolean("esqueleto_reforcado"), jsonClone.getBoolean("sentidos_agucados"), jsonClone.getBoolean("pele_adaptativa"),
                                jsonClone.getBoolean("raio_laser"))
                        val timestamp = jsonClone.getString("data_cadastro");
                        clone.data_criacao = Date(timestamp.toLong())
                    clone.id = jsonClone.getInt("id")

                        listaClone.add(clone);

                }

                context.recebe_nova_lista(listaClone);
            }
        }
        this.sendRequest(addr_clones, Request.Method.GET, context,  Call_Listar())
    }

    fun remove_clone(context: MainActivity, id: Int) {

        class Call_Listar : Callable() {
            override fun sucesso(response : String) {
                context.atualiza_lista();
            }
        }

        this.sendRequest(addr_clones+"/$id", Request.Method.DELETE,context, Call_Listar())
    }

    fun adicionar_clone(context: Details, clone: Clone) {
        class Call_Listar : Callable() {
            override fun sucesso(response : String) {
                if(response == "false") context.erro_nome_repetido();
                else context.clone_criado();
            }
        }

        this.sendPostRequest(addr_clones, clone, context, Call_Listar())
    }

    fun editar_clone(context: Details, clone: Clone) {

        class Call_Listar : Callable() {
            override fun sucesso(response : String) {
                if(response == "false") context.erro_nome_repetido();
                else context.clone_criado();
            }
        }

        this.sendPostRequest(addr_clones+"/${clone.id}", clone, context, Call_Listar())
    }

    private fun sendRequest(addr: String, type: Int,  contextMain: Context, callable : Callable?) {

        val stringRequest = StringRequest(type, addr,
                object : Response.Listener<String> {
                    override fun onResponse(response: String) {
                        Log.d("requestT", "Response is: $response")

                        callable?.sucesso(response)
                    }
                }, object : Response.ErrorListener {
            override fun onErrorResponse(error: VolleyError) {
                VolleyLog.e("Error: ", error.toString());
                VolleyLog.e("Error: ", error.message);
                callable?.falha(contextMain)
            }
        })

        QueueSingleton.getInstance(contextMain)?.addToRequestQueue(stringRequest)
    }

    private fun sendPostRequest(addr: String, clone: Clone, contextMain: Context, callable : Callable?) {
        VolleyLog.DEBUG = true;
        val stringRequest = object : StringRequest(Request.Method.POST, addr,
                object : Response.Listener<String> {
                    override fun onResponse(response: String) {
                        Log.d("requestT", "Response is: $response")

                        callable?.sucesso(response)
                    }
                }, object : Response.ErrorListener {
            override fun onErrorResponse(error: VolleyError) {
                VolleyLog.e("Error: ", error.toString());
                VolleyLog.e("Error: ", error.message);
                callable?.falha(contextMain)
            }
        }) {
            @Throws(AuthFailureError::class)
            override fun getParams():  Map<String, String> {
                    val params = HashMap<String, String>()
                    params["nome"] = clone.nome
                    params["idade"] = clone.idade.toString()
                    params["braco_mecanico"] = clone.braco_mecanico.toString()
                    params["esqueleto_reforcado"] = clone.esqueleto_reforcado.toString()
                    params["sentidos_agucados"] = clone.sentidos_agucados.toString()
                    params["pele_adaptativa"] = clone.pele_adaptativa.toString()
                    params["raio_laser"] = clone.raio_laser.toString()
                    return params
                }
        }

        QueueSingleton.getInstance(contextMain)?.addToRequestQueue(stringRequest)
    }

    fun mudar_addr(novo: String){
        addr = "http://$novo:8080"
        addr_clones = "$addr/clones"

        Log.d("ip", addr)
        PreferenceManager.getDefaultSharedPreferences(contextmain).edit().putString("hostAddr", addr).apply();
    }

    open abstract class Callable {

        abstract fun sucesso(response : String);
        fun falha(contextMain: Context){
            val alertDialog = AlertDialog.Builder(contextMain).create()
            alertDialog.setTitle("Importante!")
            alertDialog.setMessage("O servidor não foi encontrado!")
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK"
            ) { dialog, which -> dialog.dismiss() }
            alertDialog.show()
        }
    }
}
