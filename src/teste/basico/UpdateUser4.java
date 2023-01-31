package teste.basico;

import infrastructure.DAO;
import model.basic.User;

public class UpdateUser4 {
	public static void main(String [] args) {
		
		DAO<User> userDAO = new DAO<User>(User.class);
		
		User user = userDAO.getById(6L);
		userDAO.detach(user); // recom)endado fazer isso. detach() tira o objeto do estado gerenciado pelo EntityManager, 
							  // porque quero evitar o ele persista o dado no banco automaticamente
		
		user.setName("Fabricio");
		user.setEmail("fabricio@gmail.com");
		
		
		
		userDAO.begin()
			   .merge(user) // persistir no banco de dados
			   .commit()
			   .closeDAO();
		
		/*
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
	
		em.getTransaction().begin();
			User user = em.find(User.class, 5L);
			em.detach(user); // recom)endado fazer isso. detach() tira o objeto do estado gerenciado pelo EntityManager, 
							 // porque quero evitar o ele persista o dado no banco automaticamente
			// user.setName("Carla");
			user.setEmail("carla@hotmail.com");
			
			em.merge(user); // persistir no banco de dados
			
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		*/
	}
}
