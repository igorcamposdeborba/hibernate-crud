package teste.basico.onetomany;

import infrastructure.DAO;
import model.basic.onetomany.Order;
import model.basic.onetomany.OrderItem;

public class GetOrder {
	public static void main (String [] args) {
		
		DAO<Order> orderDAO = new DAO<Order>(Order.class);
		
		Order order = orderDAO.getById(1L);
		
		for (OrderItem i : order.getOrder()) {
			System.out.println(i.getQuantity());
			System.out.println(i.getProduct().getName());
		}
		
		orderDAO.closeDAO();
		
	}
}
