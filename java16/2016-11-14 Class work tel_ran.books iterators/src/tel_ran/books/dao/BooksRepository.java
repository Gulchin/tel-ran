package tel_ran.books.dao;

import java.util.*;

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
import tel_ran.books.utils.BookIterator;

public class BooksRepository implements Iterable<Book>{
	private ArrayList<Book> books=new ArrayList<>();
	
	public boolean addBook(Book book){		
			if (getBook(book.getIsbn())!=null)
					return false;		
			books.add(book);
			return true;					
	}
	
	public boolean removeBook(long isbn){
		Iterator<Book> it=books.iterator();
		while (it.hasNext()){
			Book book=it.next();
			if(book.getIsbn()==isbn) {
				it.remove();
				return true;
			}
		}
		return false;
	}
	
	public Book getBook(long isbn){
		for(Book book: books){
			if(book.getIsbn()==isbn) return book;
		}
		return null;
	}
	
	public Book getBookByIndex(int index){
		return books.get(index);
	}
	
	public int getSize(){
		return books.size();
	}
	
	
	public List<Book>getBooksLibrary(Library library, String orderBy){
		return getBookByPredicate(new PredicateLibrary(library), orderBy);
	}
	
	public List<Book> getBooksByAuthor(String author, String orderBy){
		return getBookByPredicate(new PredicateAuthor(author), orderBy);
	}
	
	public List<Book> getBooksByPrice(int from, int to, String orderBy){
		return getBookByPredicate(new PredicatePrice(from,to), orderBy);
	}
	
	private List<Book> getBookByPredicate(Predicate<Book> predicate, String orderBy){
		ArrayList<Book> result=new ArrayList<>();
		for(Book book: books){
			if (predicate.test(book)){
				result.add(book);
			}
		}
		Collections.sort(result,getComporator(orderBy));
		return result;
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


	@Override
	public Iterator<Book> iterator() {
		return new BookIterator(this);
	}
	
	
}
