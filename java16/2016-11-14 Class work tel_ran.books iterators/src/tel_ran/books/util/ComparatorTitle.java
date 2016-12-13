package tel_ran.books.util;

import java.util.Comparator;

import tel_ran.books.entities.Book;

public class ComparatorTitle implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		
		return o1.getTitle().compareToIgnoreCase(o2.getTitle());
	}

}
