package licenta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")

public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAdmin")
	private int idAdmin;
	
	@Column(name = "numeAdmin")
	private String numeAdmin;
	
	@Column(name = "emailAdmin")
	private String emailAdmin;
	
	@Column(name = "camin")
	private String camin;
	
	@Column(name = "telefonAdmin")
	private String telefonAdmin;

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNumeAdmin() {
		return numeAdmin;
	}

	public void setNumeAdmin(String numeAdmin) {
		this.numeAdmin = numeAdmin;
	}

	public String getEmailAdmin() {
		return emailAdmin;
	}

	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}

	public String getCamin() {
		return camin;
	}

	public void setCamin(String camin) {
		this.camin = camin;
	}

	public String getTelefonAdmin() {
		return telefonAdmin;
	}

	public void setTelefonAdmin(String telefonAdmin) {
		this.telefonAdmin = telefonAdmin;
	}
	
	

}
