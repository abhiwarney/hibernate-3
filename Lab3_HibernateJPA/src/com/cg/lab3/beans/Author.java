package com.cg.lab3.beans;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Author {
	@Id
	private int ID;
	private String name;
	@OneToMany(mappedBy="author",fetch=FetchType.EAGER)
	private List<Book>books;
	public Author() {}
	
	public Author(int iD, String name) {
		super();
		ID = iD;
		this.name = name;
	}

	public Author(int iD, String name, List<Book> books) {
		super();
		ID = iD;
		this.name = name;
		this.books = books;
	}
	public Author(String name, List<Book> books) {
		super();
		this.name = name;
		this.books = books;
	}
	public Author(String name) {
		super();
		this.name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (ID != other.ID)
			return false;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Author [ID=" + ID + ", name=" + name+"]";
	}
}
