package model.basic.onetomany;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name = "tb_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Date date;
	
	@OneToMany(mappedBy = "order") // relacionamento bidirecional 
	private List<OrderItem> orderList;
	
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
	
	// composition methods
	public List<OrderItem> getOrder(){
		return orderList;
	}
	public void setOrder(List<OrderItem> orderList) {
		this.orderList = orderList;
	}
	
}
