package com.clones.desafios.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ClonesMembros implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumn(name = "id_clone", referencedColumnName = "id_clone",  foreignKey = @ForeignKey(name = "fk_clone"))
	@ManyToOne
	private Clone clone;
	
	@Id
	@JoinColumn(name = "id_membro", referencedColumnName = "id_membro",  foreignKey = @ForeignKey(name = "fk_membro"))
	@ManyToOne
	private Membro membro;

	public Clone getClone() {
		return clone;
	}

	public void setClone(Clone clone) {
		this.clone = clone;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}
	
	
	
}
