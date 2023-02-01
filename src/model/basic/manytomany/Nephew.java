package model.basic.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Nephew {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany (mappedBy = "nephews", cascade = CascadeType.PERSIST) // relacionamento bidirecional que aponta para a tabela principal, que é Uncle
	private List<Uncle> uncles = new ArrayList<Uncle>(); // composição
	
	public Nephew() {}
	
	public Nephew(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// composition methods
	public List<Uncle> getUncles(){
		return uncles;
	}
	public void setUncles(List<Uncle> uncles) {
		this.uncles = uncles;
	}
	
}
