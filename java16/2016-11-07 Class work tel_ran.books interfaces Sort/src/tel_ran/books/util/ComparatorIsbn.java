package tel_ran.books.util;

import java.util.Comparator;

import tel_ran.books.entities.Book;

public class ComparatorIsbn implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		long isbn1=o1.getIsbn();
		long isbn2=o2.getIsbn();
		return Long.compare(isbn1, isbn2);
	}



}
