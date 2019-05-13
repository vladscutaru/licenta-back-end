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
@Table(name = "student")

public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idStudent")
	private int idStudent;
	
	@Column(name = "nume")
	private String nume;
	
	@Column(name = "prenume")
	private String prenume;
	
	@Column(name = "facultate")
	private String facultate;
	
	@Column(name = "an")
	private String an;
	
	@Column(name = "oras")
	private String oras;
	
	@Column(name = "judet")
	private String judet;

	@Column(name = "telefon")
	private String telefon;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "orfan")
	private boolean orfan;
	
	@Column(name = "situatieSocialaPrecara")
	private boolean situatieSocialaPrecara;
	
	@Column(name = "situatieMedicalaSpeciala")
	private boolean situatieMedicalaSpeciala;
	
	@Column(name = "arhiva")
	private String arhiva;
	
	@Column(name = "cazat")
	private boolean cazat;
	
	@ManyToOne
	@JoinColumn(name = "camin")
	private Camin camin;
	
	@Column(name = "etaj")
	private Integer etaj;
	
	@Column(name = "camera")
	private Integer camera;
	
	@Column(name = "confirmatAnUrm")
	private boolean confirmat;

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getFacultate() {
		return facultate;
	}

	public void setFacultate(String facultate) {
		this.facultate = facultate;
	}

	public String getAn() {
		return an;
	}

	public void setAn(String an) {
		this.an = an;
	}

	public String getOras() {
		return oras;
	}

	public void setOras(String oras) {
		this.oras = oras;
	}

	public String getJudet() {
		return judet;
	}

	public void setJudet(String judet) {
		this.judet = judet;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isOrfan() {
		return orfan;
	}

	public void setOrfan(boolean orfan) {
		this.orfan = orfan;
	}

	public boolean isSituatieSocialaPrecara() {
		return situatieSocialaPrecara;
	}

	public void setSituatieSocialaPrecara(boolean situatieSocialaPrecara) {
		this.situatieSocialaPrecara = situatieSocialaPrecara;
	}

	public boolean isSituatieMedicalaSpeciala() {
		return situatieMedicalaSpeciala;
	}

	public void setSituatieMedicalaSpeciala(boolean situatieMedicalaSpeciala) {
		this.situatieMedicalaSpeciala = situatieMedicalaSpeciala;
	}

	public String getArhiva() {
		return arhiva;
	}

	public void setArhiva(String arhiva) {
		this.arhiva = arhiva;
	}

	public boolean isCazat() {
		return cazat;
	}

	public void setCazat(boolean cazat) {
		this.cazat = cazat;
	}
	
	public Camin getCamin() {
		return camin;
	}

	public void setCamin(Camin camin) {
		this.camin = camin;
	}

	public Integer getEtaj() {
		return etaj;
	}

	public void setEtaj(Integer etaj) {
		this.etaj = etaj;
	}

	public Integer getCamera() {
		return camera;
	}

	public void setCamera(Integer camera) {
		this.camera = camera;
	}

	public boolean isConfirmat() {
		return confirmat;
	}

	public void setConfirmat(boolean confirmat) {
		this.confirmat = confirmat;
	}

}
