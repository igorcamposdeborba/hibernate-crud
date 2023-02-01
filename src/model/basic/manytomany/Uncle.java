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
public class Uncle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany (cascade = CascadeType.PERSIST) // Persist: salvar no banco todas as tabelas com registros relacionados, mesmo que aquele registro não tenha tido o comando de salvar no banco, mas outro registro da mesma tabela recebeu o comando de salvar no banco
	@JoinTable(name = "uncles_nephews",
			   joinColumns = @JoinColumn(name = "uncle_id", referencedColumnName = "id"),
			   inverseJoinColumns = @JoinColumn(name = "nephew_id", referencedColumnName = "id")) // criar tabela intermediária para muitos para muitos
	private List<Nephew> nephews = new ArrayList<Nephew>(); // composição
	
	
	public Uncle() {}
	
	public Uncle(String name) {
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
	public List<Nephew> getNephews(){
		return nephews;
	}
	public void setNephews(List<Nephew> nephews) {
		this.nephews = nephews;
	}
	
	public void addNephew(Nephew nephew) {
		if (nephew != null && !getNephews().contains(nephew)) {
			getNephews().add(nephew);
			
			if (!nephew.getUncles().contains(this)) {
				nephew.getUncles().add(this);
			}
		}
		
	}
}
