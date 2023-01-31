package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class UpdateUser1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin(); // transaction sempre precisa quando for persistir algo no banco
		
			User user = em.find(User.class, 5L);
			user.setName("Luana");
			user.setEmail("luana@gmail.com");
			
			em.merge(user); // método para atualizar dado no banco de dados
				
			System.out.println(user.getEmail());
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
