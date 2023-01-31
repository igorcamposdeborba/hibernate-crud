package model.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tb_products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "prod_name", nullable = false, length = 120) // nullable: torna o atributo obrigatório. length é a quantidade de caracteres
	private String name;
	
	@Column(name = "prod_price", nullable = false, precision = 11, scale = 2) // precision diz a quantidade total de dígitos. scale é quantos n° depois da virgula
	private Double price;
	
	public Product() {} // para consultar o banco, eu preciso do construtor default sem nada
	
	public Product(String name, Double price) {
		this.name = name;
		this.price= price;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Double getPrice() {
		return price;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
