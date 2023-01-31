package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class NewUser {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		User novoUsuario = new User("Trajano", "trajano@hotmail.com.br");
		
		em.getTransaction().begin();
		
			em.persist(novoUsuario);
		
		em.getTransaction().commit();
		
		
		System.out.println("O id gerado foi: " + novoUsuario.getId());
		
		em.close();
		emf.close();
	}
}