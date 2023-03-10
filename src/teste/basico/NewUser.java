package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import infrastructure.DAO;
import model.basic.Product;
import model.basic.User;

public class NewUser {

	public static void main(String[] args) {
		
		DAO<User> userDAO = new DAO<User>(User.class);
		
		User user = new User("Gabriela", "gabi@gmail.com");
		
		userDAO.begin()
			   .add(user)
			   .commit()
			   .closeDAO();
		
		System.out.println("Id do usuario: " + user.getId());
		
		/*
		// Forma manual sem DAO
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		User novoUsuario = new User("Trajano", "trajano@hotmail.com.br");
		
		em.getTransaction().begin();
		
			em.persist(novoUsuario);
		
		em.getTransaction().commit();
		
		
		System.out.println("O id gerado foi: " + novoUsuario.getId());
		
		em.close();
		emf.close();
		*/
	}
}