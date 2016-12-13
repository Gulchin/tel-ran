package tel_ran.books.util;

import java.util.function.Predicate;

import tel_ran.books.entities.Book;

public class PredicatePrice implements Predicate<Book> {
	private int  from,to;



	public PredicatePrice(int from, int to) {
		super();
		this.to = to;
		this.from = from;
	}



	@Override
	public boolean test(Book book) {
		if (book==null) return false;
		int price=book.getPrice();
		return price>=from && price<=to;
	}

}
