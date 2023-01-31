package teste.basico;

import infrastructure.DAO;
import model.basic.Product;

public class NewProduct {
	public static void main(String[] args) {
				
		Product product = new Product("Notebook", 6300.00);
		
		DAO<Product> productDAO = new DAO<Product>(Product.class); // intanciar DAO para abstrair as consultas por meio de métodos
		productDAO.begin();
		productDAO.add(product);
		productDAO.commit();
		
		System.out.println("Id do produto: " + product.getId());
	
	}
}
