package tel_ran.books.entities;

public class Book {
	private long  isbn;
	private String title;
	private String author;
	private int price;
	private Library library;
	public Book(long isbn, String title, String author, int price, Library library) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.library = library;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public long getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public Library getLibrary() {
		return library;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return this.isbn==other.isbn;
	}
	
	
	

}
