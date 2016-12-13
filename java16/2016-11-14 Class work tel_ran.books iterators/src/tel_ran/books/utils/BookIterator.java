package tel_ran.books.utils;

import java.util.Iterator;

import tel_ran.books.dao.BooksRepository;
import tel_ran.books.entities.Book;

public class BookIterator implements Iterator<Book> {
	private BooksRepository books;
	private int index=0;
	

	public BookIterator(BooksRepository books) {
		super();
		this.books = books;
	}

	@Override
	public boolean hasNext() {
		if (books==null) return false;
		return index<books.getSize();
	}

	@Override
	public Book next() {
		return books.getBookByIndex(index++);
	}

}
