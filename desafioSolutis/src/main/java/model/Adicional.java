package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Adicional {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private boolean bracoMecanico;
	private boolean esqueletoReforcado;
	private boolean sentidosAgucados;
	private boolean peleAdaptativa;
	private boolean raioLaser;
	
	@OneToOne
	@JoinColumn( name = "id_clone")
	private Clone clone;
	
}
