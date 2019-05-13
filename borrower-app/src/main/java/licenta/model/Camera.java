package licenta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "camera")

public class Camera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCamera")
	private int id;
	
	@Column(name = "numarCamera")
	private int numarCamera;
	
	@Column(name = "etaj")
	private int etaj;
	
	@ManyToOne
	@JoinColumn(name = "numarCamin")
	private Camin camin;
	
	@Column(name = "numarLocuri")
	private int numarLocuri;
	
	@Column(name = "locuriOcupate")
	private int locuriOcupate;
	
	@ManyToOne
	@JoinColumn(name = "idSefPalier")
	private Student idSefPalier;

	public int getId() {
		return id;
	}

	public void setId(int idCamera) {
		this.id = idCamera;
	}

	public Camin getCamin() {
		return camin;
	}

	public void setCamin(Camin camin) {
		this.camin = camin;
	}

	public int getNumarCamera() {
		return numarCamera;
	}

	public void setNumarCamera(int numarCamera) {
		this.numarCamera = numarCamera;
	}

	public int getEtaj() {
		return etaj;
	}

	public void setEtaj(int etaj) {
		this.etaj = etaj;
	}

	public int getNumarLocuri() {
		return numarLocuri;
	}

	public void setNumarLocuri(int numarLocuri) {
		this.numarLocuri = numarLocuri;
	}

	public int getLocuriOcupate() {
		return locuriOcupate;
	}

	public void setLocuriOcupate(int locuriOcupate) {
		this.locuriOcupate = locuriOcupate;
	}

	public Student getIdSefPalier() {
		return idSefPalier;
	}

	public void setIdSefPalier(Student idSefPalier) {
		this.idSefPalier = idSefPalier;
	}
	
	

}
