package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class UpdateUser2 {
	public static void main (String [] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			
			User user = em.find(User.class, 5L);
			user.setName("Igor Campos de Borba");
			user.setEmail("igor@yahoo.com.br");
			
			// em.merge(user); // o hibernate persiste no banco mesmo não tendo merge() porque ele tem o getTransaction
			
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}
