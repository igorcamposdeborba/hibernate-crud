package teste.basico.onetoone;

import infrastructure.DAO;
import model.basic.onetoone.Client;
import model.basic.onetoone.Seat;

public class NewClientSeat2 {
	public static void main (String [] args) {
		
		Seat seat = new Seat();
		Client client = new Client("Vinicius", seat);
		
		DAO<Client> clientDAO = new DAO<Client>(Client.class);
		clientDAO.begin()
				 .add(client)
				 .commit()
				 .closeDAO();
		
	}
}
