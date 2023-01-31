package model.basic.onetomany;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "tb_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Date date;
	
	
	public Order() {
		this.date = new Date();
	}
	public Order(Date date) {
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}
	public Date getDate() {
		return date;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDate() {
		this.date = date;
	}
	
}
