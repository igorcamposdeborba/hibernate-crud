package teste.basico;

import java.util.List;

import infrastructure.DAO;
import model.basic.User;

public class GetUser {
	public static void main (String [] args) {
		
		DAO<User> userDAO = new DAO<User>(User.class);
		
		User user = userDAO.getById(3L);
		
		System.out.println("Id: " + user.getId()
						+ ", Nome: " + user.getName());
		
		userDAO.closeDAO();
		
		/*
		// Forma manual sem DAO
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); // exercicios-jpa diz qual é o banco de dados que eu acesso
		EntityManager em = emf.createEntityManager();
		
		User user = em.find(User.class, 4L);
		System.out.println(user.getName());
		
		em.close();
		emf.close();
		*/
	}
}
