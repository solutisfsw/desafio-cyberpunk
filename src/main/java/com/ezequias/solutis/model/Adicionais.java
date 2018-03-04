package com.ezequias.solutis.model;

import javax.persistence.*;

@Entity
@Table(name = "adicionais")
public class Adicionais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean bracoMecanico = false;

    private Boolean esqueletoReforcado = false;

    private Boolean sentidosAgucados = false;

    private Boolean peleAdaptativa = false;

    private Boolean raioLaser = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getBracoMecanico() {
        return bracoMecanico;
    }

    public void setBracoMecanico(Boolean bracoMecanico) {
        this.bracoMecanico = bracoMecanico;
    }

    public Boolean getEsqueletoReforcado() {
        return esqueletoReforcado;
    }

    public void setEsqueletoReforcado(Boolean esqueletoReforcado) {
        this.esqueletoReforcado = esqueletoReforcado;
    }

    public Boolean getSentidosAgucados() {
        return sentidosAgucados;
    }

    public void setSentidosAgucados(Boolean sentidosAgucados) {
        this.sentidosAgucados = sentidosAgucados;
    }

    public Boolean getPeleAdaptativa() {
        return peleAdaptativa;
    }

    public void setPeleAdaptativa(Boolean peleAdaptativa) {
        this.peleAdaptativa = peleAdaptativa;
    }

    public Boolean getRaioLaser() {
        return raioLaser;
    }

    public void setRaioLaser(Boolean raioLaser) {
        this.raioLaser = raioLaser;
    }
}
