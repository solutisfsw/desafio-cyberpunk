package com.example.mnmat.cyberpunk.models

import java.io.Serializable
import java.util.*

/**
 * Created by mnmat on 02/03/2018.
 */
data class Clone (var nome: String, var idade: Int, var braco_mecanico: Boolean, var esqueleto_reforcado: Boolean,
                  var sentidos_agucados: Boolean, var pele_adaptativa: Boolean, var raio_laser: Boolean) : Serializable {
     var id: Int? = null
     var data_criacao: Date? = null


}