package teste.basico.onetoone;

import javax.persistence.OneToOne;

import infrastructure.DAO;
import model.basic.onetoone.Client;
import model.basic.onetoone.Seat;

public class GetClientSeat {
	public static void main (String [] args) {
		
		DAO<Client> clientDAO = new DAO<Client>(Client.class);
	    Client client = clientDAO.getById(1L);

	    System.out.println(client.getSeat().getName()); // graças ao relacionamento bidirecional com @OneToOne(mappedBy = "seat") eu consigo acessar as duas tabelas não importando a partir de quem eu instancie. O normal é uma tabela conhecer a sua composição, e não a composição conhecer a sua classe que a implementou

	    clientDAO.closeDAO();
	    
	    
	    DAO<Seat> seatDAO = new DAO<Seat>(Seat.class);
	    Seat seat = seatDAO.getById(1L);
	    
	    System.out.println(seat.getClient().getName()); // graças ao relacionamento bidirecional com @OneToOne(mappedBy = "seat") eu consigo acessar as duas tabelas 
	    
	    seatDAO.closeDAO();
	}
}
