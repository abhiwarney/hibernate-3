package com.cg.lab3.daoservices;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.cg.lab3.beans.Author;
import com.cg.lab3.beans.Book;
public class AuthorDaoImpl implements AuthorDao{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
	@Override
	public Author save(Author author) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(author);
		entityManager.getTransaction().commit();
		entityManager.close();
		return author;
	}
	@Override
	public Author find(int authorId) {
		return entityManagerFactory.createEntityManager().find(Author.class, authorId);
	}

	@Override
	public Author update(Author author) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(author);
		entityManager.getTransaction().commit();
		entityManager.close();
		return author;
	}

}
