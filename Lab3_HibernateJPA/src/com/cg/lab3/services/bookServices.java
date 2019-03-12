package com.cg.lab3.services;
import java.util.List;
import com.cg.lab3.beans.Book;
public interface bookServices {
	Book acceptBookDetails(String title,float price,int authorId,String authorName);
	List<Book> findBooksByAuthorName(String name);
	List<Book> displayAllBooks();
	List<Book> findBooksByPriceRange(float lowerPriceLimit,float upperPriceLimit);
}
