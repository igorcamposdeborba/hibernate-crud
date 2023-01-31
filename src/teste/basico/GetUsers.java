package teste.basico;

import java.util.List;

import infrastructure.DAO;
import model.basic.User;

public class GetUsers {
	public static void main(String[] args) {
		
		DAO<User> userDAO = new DAO<User>(User.class);
		
		List<User> userList = userDAO.getAll(100, 0);
		
		for (User i : userList) {
			System.out.println("Id: " + i.getId() + 
							 ", Nome: " + i.getName() +
							 ", E-mail " + i.getEmail());
		}
		
		userDAO.closeDAO();
		
		/*
		// Forma manual sem DAO
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT u FROM User u";
		
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setMaxResults(50);
		
		List<User> userList = query.getResultList(); // consulta ao banco de dados
		
		for (User i : userList) {
			System.out.println("Id: " + i.getId()
							+ " E-mail: " + i.getEmail());
		}
		
		em.close();
		emf.close();
		*/
	}
}
