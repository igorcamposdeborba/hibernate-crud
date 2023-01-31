package infrastructure;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<T> {
	
	private static EntityManagerFactory emf; // Fábrica de conexões
	private static EntityManager em; // Gerenciador da conexão
	private Class<T> classe;
	
	static { // executa somente 1 vez, quando carrega a classe
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa"); // exercicios-jpa diz qual é o banco de dados que eu acesso
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<T> classe) { // passo a Classe para a query saber qual entity (tabela) do banco estou acessando
		this.classe = classe;
		em = emf.createEntityManager(); // criar gerenciador da conexão EntityManager, que gerencia o comando sql
	}
	
	public DAO<T> begin(){
		em.getTransaction().begin();
		return this; // retorna a própria classe DAO
	}
	public DAO<T> commit() {
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<T> add(T entity){
		em.persist(entity);
		return this;
	}
	public DAO<T> addAtomic(T entity) {
		begin();
		add(entity);
		commit();
		return this;
	}
	
	public List<T> getAll(int limitRegisters, int offset){
		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula");
		}
		String jpql = "SELECT e FROM " + classe.getName() + " e";
		TypedQuery<T> query = em.createQuery(jpql, classe);
		query.setMaxResults(limitRegisters);
		query.setFirstResult(offset);
		
		return query.getResultList();
	}
	
	public T getById(Long id) {
		unsupportedOperationException(classe);
		
		String jpql = "SELECT e FROM " + classe.getName() + " e WHERE id = " + id;
		TypedQuery<T> query = em.createQuery(jpql, classe);
		
		return query.getSingleResult();
	}
	
	public DAO<T> deleteById(Long id) {
		unsupportedOperationException(classe);
		
		String jpql = "DELETE FROM " + classe.getName() + " e WHERE id = " + id;

		Object query = em.createQuery(jpql).executeUpdate();
		
		return this;
	}
	
	public void closeDAO() {
		em.close();
	}
	
	public void unsupportedOperationException(Class<T> classe) {
		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula");
		}
	}
}
