package tel_ran.books.util;

import java.util.function.Predicate;

import tel_ran.books.entities.Book;

public class PredicateAuthor implements Predicate<Book> {
	private String author;
	
	

	public PredicateAuthor(String author) {
		super();
		this.author = author;
	}



	@Override
	public boolean test(Book book) {
		if (book==null) return false;
		return author.equals(book.getAuthor());
	}

}
