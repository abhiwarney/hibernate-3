package com.cg.lab3.daoservices;
import java.util.List;
import com.cg.lab3.beans.Book;
public interface BookDao {
	Book save(Book book);
	List<Book>findAll();
	List<Book>findAllByName(String name);
	List<Book>findAllByPriceRange(float lowerPriceLimit,float upperPriceLimit);
}
