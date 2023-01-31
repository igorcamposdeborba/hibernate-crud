package model.basic.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tb_clients")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToOne // relacionamento 1:1. O cliente sabe tudo sobre o assento dele
	@JoinColumn(name = "seat_id", unique = true) // name define o nome da coluna no banco de dados. unique obriga que não tenha repetição (do mesmo assento para dois clientes, que seria uma inconsistência do banco de dados)
	private Seat seat; // composição 1:1
	
	public Client() {}
	public Client(String name, Seat seat) {
		this.name = name;
		this.seat = seat;
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
	
	
}
