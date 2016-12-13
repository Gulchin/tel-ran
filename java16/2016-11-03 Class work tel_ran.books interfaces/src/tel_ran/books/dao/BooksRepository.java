package tel_ran.books.dao;

import java.util.Arrays;

import tel_ran.books.entities.Book;
import tel_ran.books.entities.Library;
import tel_ran.books.interfaces.PredicateBook;
import tel_ran.books.util.PredicateAuthor;
import tel_ran.books.util.PredicateLibrary;
import tel_ran.books.util.PredicatePrice;

public class BooksRepository {
	private Book [] books=new Book[0];
	
	public boolean addBook(Book book){		
			if (getBook(book.getIsbn())!=null)
					return false;		
			books=Arrays.copyOf(books, books.length+1);
			books[books.length-1]=book;
			return true;					
	}
	
	public boolean removeBook(long isbn){
		Book [] temp=new Book[books.length-1];
		int indexTmp=0;
		boolean found=false;
		for (int i=0;i<books.length;i++){
			if(books[i].getIsbn()!=isbn){
				temp[indexTmp++]=books[i];
			} else found=true;
		}		
		books=temp;
		return found;
	}
	
	public Book getBook(long isbn){
		
		return books[getBookIndex(isbn)];
	}
	
	public int getBookIndex(long isbn){
		
		for (int i=0;i<books.length;i++)
			if(books[i].getIsbn()==isbn)  {
				return i;
			}

		return -1;	
	}
	
	
	public Book[]getBooksLibrary(Library library){
		return getBookByPredicate(new PredicateLibrary(library));
	}
	
	public Book[] getBooksByAuthor(String author){
		return getBookByPredicate(new PredicateAuthor(author));
	}
	
	public Book[] getBooksByPrice(int from, int to){
		return getBookByPredicate(new PredicatePrice(from,to));
	}
	
	private Book[]getBookByPredicate(PredicateBook predicate){
		Book [] result=new Book [books.length];
		int count=0;
		for(Book book: books){
			if (predicate.test(book)){
				result[count++]=book;
			}
		}
		return Arrays.copyOf(result, count);
	}
	
}
