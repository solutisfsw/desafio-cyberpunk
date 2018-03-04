package desafioSolutis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Adicional {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(columnDefinition = "BIT", name="braco_mecanico")
	@Type(type = "org.hibernate.type.NumericBooleanType")	
	private boolean bracoMecanico;
	
	@Column(columnDefinition = "BIT", name="esqueleto_reforcado")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean esqueletoReforcado;
	
	@Column(columnDefinition = "BIT",name="sentidos_agucados")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean sentidosAgucados;
	
	@Column(columnDefinition = "BIT", name="pele_adaptativa")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean peleAdaptativa;
	
	@Column(columnDefinition = "BIT", name="raio_laser")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean raioLaser;
	
	
	@OneToOne
	@JoinColumn( name = "id_clone")	
	private Clone clone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isBracoMecanico() {
		return bracoMecanico;
	}

	public void setBracoMecanico(boolean bracoMecanico) {
		this.bracoMecanico = bracoMecanico;
	}

	public boolean isEsqueletoReforcado() {
		return esqueletoReforcado;
	}

	public void setEsqueletoReforcado(boolean esqueletoReforcado) {
		this.esqueletoReforcado = esqueletoReforcado;
	}

	public boolean isSentidosAgucados() {
		return sentidosAgucados;
	}

	public void setSentidosAgucados(boolean sentidosAgucados) {
		this.sentidosAgucados = sentidosAgucados;
	}

	public boolean isPeleAdaptativa() {
		return peleAdaptativa;
	}

	public void setPeleAdaptativa(boolean peleAdaptativa) {
		this.peleAdaptativa = peleAdaptativa;
	}

	public boolean isRaioLaser() {
		return raioLaser;
	}

	public void setRaioLaser(boolean raioLaser) {
		this.raioLaser = raioLaser;
	}
	
	public Clone getClone() {
		return clone;
	}

	public void setClone(Clone clone) {
		this.clone = clone;
	}
	
	public boolean algumAdicional() {
		return (this.bracoMecanico || this.esqueletoReforcado || this.peleAdaptativa || this.raioLaser || this.sentidosAgucados);
	}
}
