package teste.basico.onetoone;

import infrastructure.DAO;
import model.basic.onetoone.Client;
import model.basic.onetoone.Seat;

public class NewClientSeat {
	public static void main (String [] args) {
		
		Seat seat = new Seat("28A");
		Client client = new Client("Igor", seat);

		DAO<Object> DAO = new DAO<>();
		
		DAO.begin()
		   .add(seat)
		   .commit();
		
		DAO.addAtomic(client).closeDAO();
		
		
	}
}
