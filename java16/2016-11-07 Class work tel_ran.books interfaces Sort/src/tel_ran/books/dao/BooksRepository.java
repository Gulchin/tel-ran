package tel_ran.books.dao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

import tel_ran.books.entities.Book;
import tel_ran.books.entities.Library;
import tel_ran.books.util.ComparatorAuthor;
import tel_ran.books.util.ComparatorIsbn;
import tel_ran.books.util.ComparatorPrice;
import tel_ran.books.util.ComparatorTitle;
import tel_ran.books.util.PredicateAuthor;
import tel_ran.books.util.PredicateLibrary;
import tel_ran.books.util.PredicatePrice;

public class BooksRepository {
	private Book [] books=new Book[0];
	
	public boolean addBook(Book book){		
			if (getBookIndex(book.getIsbn())!=-1)
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
	
	
	public Book[]getBooksLibrary(Library library, String orderBy){
		return getBookByPredicate(new PredicateLibrary(library), orderBy);
	}
	
	public Book[] getBooksByAuthor(String author, String orderBy){
		return getBookByPredicate(new PredicateAuthor(author), orderBy);
	}
	
	public Book[] getBooksByPrice(int from, int to, String orderBy){
		return getBookByPredicate(new PredicatePrice(from,to), orderBy);
	}
	
	private Book[]getBookByPredicate(Predicate<Book> predicate, String orderBy){
		Book [] result=new Book [books.length];
		int count=0;
		for(Book book: books){
			if (predicate.test(book)){
				result[count++]=book;
			}
		}
		Book[]res=Arrays.copyOf(result, count);
		sortBooks(res,orderBy);
		return res;
	}

	private void sortBooks(Book[] res, String orderBy) {
		Comparator<Book> comp=getComporator(orderBy);
		Arrays.sort(res,comp);

	}

	private Comparator<Book> getComporator(String orderBy) {
		//Comparator<Book> res=null;
		switch (orderBy.toLowerCase()) {
		case("author"): 
			return new ComparatorAuthor();
		case("title"): 
			return new ComparatorTitle();
		case("isbn"): 
			return new ComparatorIsbn();
		case("price"): 
			return new ComparatorPrice();
		
		default: return null;
	}
	}
	
	
}
