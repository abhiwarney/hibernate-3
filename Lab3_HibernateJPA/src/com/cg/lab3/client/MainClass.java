package com.cg.lab3.client;

import com.cg.lab3.services.BookServicesImpl;
import com.cg.lab3.services.bookServices;

public class MainClass {

	public static void main(String[] args) {
		bookServices bookServices = new BookServicesImpl();
		
		  System.out.println(bookServices.acceptBookDetails("TravelEverest", 67.9F,123, "Ramesh Ahuja"));
		  System.out.println(bookServices.acceptBookDetails("PunjabKesari", 97.9F, 123,"Ramesh Ahuja"));
		  System.out.println(bookServices.acceptBookDetails("IndiaHeritage", 45.9F,125, "Suresh Ahuja"));
		  
		  System.out.println(bookServices.displayAllBooks());
		  
		  System.out.println(bookServices.findBooksByAuthorName("Ramesh Ahuja"));
		  
		  System.out.println(bookServices.findBooksByPriceRange(10.0F, 50.0F));
		  }
}
