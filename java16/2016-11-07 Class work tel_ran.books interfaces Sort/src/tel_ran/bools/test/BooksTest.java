package tel_ran.bools.test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import tel_ran.books.dao.BooksRepository;
import tel_ran.books.entities.Book;
import tel_ran.books.entities.Library;

public class BooksTest {
	Library libary =new Library("Central", "Rehovot");
	Book book1=new Book(123,"Dead souls","Gogol",100,libary);
	Book book2=new Book(124,"War and Piece","Tolstoy",200,libary);
	Book book3=new Book(125,"12 chairs","Ilf & Petrov",50,libary);
	
	Book[] allBooks={book1,book2,book3};
	Book[] booksByAuthor={book1,book3,book2};
	Book[] booksByPrice={book3,book1,book2};
	Book[] bookByTitle={book3,book1,book2};
	BooksRepository repository;
	
	@Before
	public void setAp(){
		repository=new BooksRepository();
		for (Book book: allBooks){
			repository.addBook(book);
		}
	}
	
	@Test
	public void testBySort() {
		assertArrayEquals(booksByAuthor, repository.getBooksLibrary(libary, "Author"));
		assertArrayEquals(allBooks, repository.getBooksLibrary(libary, "isbn"));
		assertArrayEquals(booksByPrice, repository.getBooksLibrary(libary, "price"));
	}

}
