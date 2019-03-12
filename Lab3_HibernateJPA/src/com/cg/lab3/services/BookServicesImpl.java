package com.cg.lab3.services;

import java.util.List;
import com.cg.lab3.beans.Author;
import com.cg.lab3.beans.Book;
import com.cg.lab3.daoservices.AuthorDao;
import com.cg.lab3.daoservices.AuthorDaoImpl;
import com.cg.lab3.daoservices.BookDao;
import com.cg.lab3.daoservices.BookDaoImpl;
public class BookServicesImpl implements bookServices{
	BookDao bookDao = new BookDaoImpl();
	AuthorDao authorDao=new AuthorDaoImpl();
	@Override
	public Book acceptBookDetails(String title, float price, int authorId, String authorName) {
		Author author=new Author(authorId,authorName);
		if(authorDao.find(authorId)==null) {
			author=authorDao.save(author);
		}
		else
			author=authorDao.update(author);
		return bookDao.save(new Book(title, price,author));
	}

	@Override
	public List<Book> findBooksByAuthorName(String name) {
		return bookDao.findAllByName(name);
	}

	@Override
	public List<Book> displayAllBooks() {
		return bookDao.findAll();
	}

	@Override
	public List<Book> findBooksByPriceRange(float lowerPriceLimit,float upperPriceLimit) {
		return bookDao.findAllByPriceRange(lowerPriceLimit, upperPriceLimit);
	}

}
