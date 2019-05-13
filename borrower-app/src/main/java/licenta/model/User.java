package licenta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "user_name")
	private String name;
	
	@Column(name = "user_telephone")
	private String telephone;
	
	@Column(name = "user_type")
	private String type;
	
	@Column(name = "user_city")
	private String city;
	

	@Column(name = "longitude")
	private double longitude;
	

	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "user_rating")
	private String rating;
	
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_score")
	private int score;
	
	@Column(name = "lender_score")
	private int lenderScore;
	
	@Column(name = "borrower_score")
	private int borrowerScore;

	@Column(name = "user_surname")
	private String surname;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "borrow_no")
	private int borrowNo;
	
	@Column(name = "lender_no")
	private int lenderNo;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "selfdescription")
	private String selfdescription;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLenderScore() {
		return lenderScore;
	}

	public void setLenderScore(int lenderScore) {
		this.lenderScore = lenderScore;
	}

	public int getBorrowerScore() {
		return borrowerScore;
	}

	public void setBorrowerScore(int borrowerScore) {
		this.borrowerScore = borrowerScore;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getBorrowNo() {
		return borrowNo;
	}

	public void setBorrowNo(int borrowNo) {
		this.borrowNo = borrowNo;
	}

	public int getLenderNo() {
		return lenderNo;
	}

	public void setLenderNo(int lenderNo) {
		this.lenderNo = lenderNo;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSelfdescription() {
		return selfdescription;
	}

	public void setSelfdescription(String selfdescription) {
		this.selfdescription = selfdescription;
	}



}