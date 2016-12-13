package tel_ran.books.util;

import java.util.function.Predicate;

import tel_ran.books.entities.Book;
import tel_ran.books.entities.Library;

public class PredicateLibrary implements Predicate<Book> {
	private Library library;
	

	public PredicateLibrary(Library library) {
		super();
		this.library = library;
	}


	@Override
	public boolean test(Book book) {
		if (book==null) return false;
		return library.equals(book.getLibrary());
	}

}
