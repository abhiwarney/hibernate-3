package com.cg.lab3.daoservices;
import com.cg.lab3.beans.Author;
public interface AuthorDao {
	Author save(Author author);
	Author update(Author author);
	Author find(int authorId);
}
