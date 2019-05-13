package licenta.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long id;

	@Column(name = "item_name")
	private String name;
	
	@Column(name = "item_usage")
	private String usage;
	
	@Column(name = "item_description")
	private String description;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "period")
	private String period;
	
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "guarantee")
	private double guarantee;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date start;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date end;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="owner_id")
	private User owner;

	
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

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descripyion) {
		this.description = descripyion;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	

}