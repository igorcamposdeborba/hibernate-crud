package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.basic.User;

public class GetUsers {
	public static void main(String[] args) {
		
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
	}
}
