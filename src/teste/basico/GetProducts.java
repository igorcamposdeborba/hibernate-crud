package teste.basico;

import java.util.List;

import infrastructure.DAO;
import model.basic.Product;

public class GetProducts {

	public static void main(String[] args) {
		
		DAO<Product> daoProducts = new DAO<>(Product.class);
		List<Product> daoProductsList = daoProducts.getAll(100, 0);
		
		for (Product i : daoProductsList) {
			System.out.println("Id do produto: " + i.getId()
							+ " Nome: " + i.getName()
							+ "Preco: " + i.getPrice());
		}

		daoProducts.closeDAO();
	}

}
