package model.basic.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import model.basic.Product;

@Entity (name = "tb_order_item")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int quantity;
	@Column(nullable = false)
	private Double price;
	
	@ManyToOne() // Many (OrderItem) tem One (Order)
	private Order order; // composição
	
	@ManyToOne()
	private Product product;
	
	public OrderItem() {}
	
	public OrderItem(int quantity, Order order, Product product) {
		this.setQuantity(quantity);
		this.setOrder(order);
		this.setProduct(product);
	}
	
	// access methods
	public Long getId() {
		return id;
	}
	public int getQuantity() {
		return quantity;
	}
	public Double getPrice() {
		return price;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	// composition methods
	public Order getOrder() {
		return order;
	}
	public Product getProduct() {
		return product;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public void setProduct(Product product) {
		this.product = product;
		
		if (product != null && this.price == null) { // atribuir preço do produto na classe OrderItem
			this.setPrice(product.getPrice());
		}
	}
}