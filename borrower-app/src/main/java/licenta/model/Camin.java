package licenta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "camin")

public class Camin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCamin")
	private int idCamin;
	
	@Column(name = "numarCamin")
	private int numarCamin;
	
	@Column(name = "numarTotalLocuri")
	private String numarLocuri;
	
	@Column(name = "numarEtaje")
	private String numarEtaje;
	
	@Column(name = "locuriOcupate")
	private int locuriOcupate;
	
	@Column(name = "facultate")
	private String facultate;
	
	@Column(name = "numeSefCamin")
	private String numeSefCamin;

	public int getIdCamin() {
		return idCamin;
	}

	public void setIdCamin(int idCamin) {
		this.idCamin = idCamin;
	}

	public int getNumarCamin() {
		return numarCamin;
	}

	public void setNumarCamin(int numarCamin) {
		this.numarCamin = numarCamin;
	}

	public String getNumarLocuri() {
		return numarLocuri;
	}

	public void setNumarLocuri(String numarLocuri) {
		this.numarLocuri = numarLocuri;
	}
	
	public String getNumarEtaje() {
		return numarEtaje;
	}

	public void setNumarEtaje(String numarEtaje) {
		this.numarEtaje = numarEtaje;
	}

	public int getLocuriOcupate() {
		return locuriOcupate;
	}

	public void setLocuriOcupate(int locuriOcupate) {
		this.locuriOcupate = locuriOcupate;
	}

	public String getFacultate() {
		return facultate;
	}

	public void setFacultate(String facultate) {
		this.facultate = facultate;
	}

	public String getNumeSefCamin() {
		return numeSefCamin;
	}

	public void setNumeSefCamin(String numeSefCamin) {
		this.numeSefCamin = numeSefCamin;
	}

	
	

}
