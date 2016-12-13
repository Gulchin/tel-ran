package tel_ran.books.test;

import static org.junit.Assert.*;

import java.util.List;

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
		assertArrayEquals(booksByAuthor, toArray(repository.getBooksLibrary(libary, "Author")));
		assertArrayEquals(allBooks, toArray(repository.getBooksLibrary(libary, "isbn")));
		assertArrayEquals(booksByPrice, toArray(repository.getBooksLibrary(libary, "price")));
	}
	
	@Test
	public void testBooksIteration(){
		Book[] actual=new Book[allBooks.length];
		int i=0;
		for (Book book:repository){
			actual[i++]=book;
		}
		assertArrayEquals(allBooks,actual);
		
	}
	
	private Book [] toArray(List<Book> books){
		Book [] result=new Book[books.size()];
		for(int i=0;i<result.length;i++){
			result[i]=books.get(i);
		}
		return result;
	}

}
