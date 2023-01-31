package teste.basico.onetomany;

import java.util.Date;

import model.basic.Product;
import model.basic.onetomany.Order;

import infrastructure.DAO;
import model.basic.onetomany.OrderItem;

public class NewOrder {
	public static void main (String [] args) {
		
		DAO<Object> orderDAO = new DAO<Object>();
		
		Order order = new Order();
		Product product = new Product("TV", 1200.0);

		OrderItem orderItem = new OrderItem(2, order, product);
		
		orderDAO.begin()
				.add(product)
				.add(order)
				.add(orderItem)
				.commit()
				.closeDAO();
		
	}
}
