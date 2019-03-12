package com.cg.lab3.daoservices;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.cg.lab3.beans.Book;
public class BookDaoImpl implements BookDao{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
	@Override
	public Book save(Book book) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(book);
		entityManager.getTransaction().commit();
		entityManager.close();
		return book;
	}

	@Override
	public List<Book> findAll() {
		return entityManagerFactory.createEntityManager().createQuery("from Book b", Book.class).getResultList();
	}

	@Override
	public List<Book> findAllByName(String name) {
		TypedQuery<Book> query=entityManagerFactory.createEntityManager().createQuery("select b from Book b JOIN b.author a where a.name=:name",Book.class);
		query.setParameter("name", "%" +name+ "%");
		return query.getResultList();
	}

	@Override
	public List<Book> findAllByPriceRange(float lowerPriceLimit, float upperPriceLimit) {
		return entityManagerFactory.createEntityManager().createQuery("from Book b where b.price>="+lowerPriceLimit+"and b.price<="+upperPriceLimit,Book.class).getResultList();
	}

}
