package com.br.cyberpunk.model;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Clone implements Serializable {
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long id;
  

  private String nome;
  
  private String data;
  
  private int idade;
 

@ManyToMany
@JoinTable
( name="Clone_Equip",
  joinColumns= {@JoinColumn(name="ID_Clone" )},
  inverseJoinColumns={ @JoinColumn(name="Equip_ID")}
)
 private List<EquipAdicionais> equip;
  

public Clone () {}
  
  
  public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}

public int getIdade() {
	return idade;
}

public void setIdade(int idade) {
	this.idade = idade;
}


public List<EquipAdicionais> getEquip() {
	return equip;
}


public void setEquip(List<EquipAdicionais> equip) {
	this.equip = equip;
}







}
  


