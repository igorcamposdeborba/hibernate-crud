package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class UpdateUser3 {
	public static void main(String [] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
	
		em.getTransaction().begin();
			User user = em.find(User.class, 5L);
			em.detach(user); // recomendado fazer isso. detach() tira o objeto do estado gerenciado pelo EntityManager, 
							 // porque quero evitar o ele persista o dado no banco automaticamente
			// user.setName("Carla");
			user.setEmail("carla@hotmail.com");
			
			em.merge(user); // persistir no banco de dados
			
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
