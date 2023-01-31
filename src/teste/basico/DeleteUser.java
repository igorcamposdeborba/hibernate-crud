package teste.basico;

import infrastructure.DAO;
import model.basic.User;

public class DeleteUser {
	public static void main (String [] args) {
		
		
		DAO<User> userDAO = new DAO<User>(User.class);
		User user = userDAO.getById(4L);
		
		System.out.println(user);
		
		
		if (user != null) {
			userDAO.begin()
				   .deleteById(4L)
				   .commit()
				   .closeDAO();
		}
		
		/*
		// Forma manual sem DAO
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		User user = em.find(User.class, 4L); // consultar o banco
		// em.detach(user); // tirar do estado gerenciado para o EntityManager não enviar automaticamente o dado para o banco
			
		if (user != null) {
			em.getTransaction().begin(); // iniciar transction
				em.remove(user); // deletar usuario no banco
				em.merge(user); // persistir no banco de dados
			em.getTransaction().commit(); // fechar transaction
		}

		em.close();
		emf.close();
		*/
	}
}
