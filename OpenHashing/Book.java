/**
 * Stores the information about a Book
 *
 * @author Karl Wurst
 */
public class Book implements Comparable<Book> {

    private String isbn;
    private String title;
    private String author;
    private int year;
    private String publisher;

    /**
     * Creates a blank Book object
     */
    public Book() {
        isbn = "";
        title = "";
        author = "";
        publisher = "";
    }

    /**
     * Creates an object with the fields filled
     * @param isbn the ISBN of the book
     * @param author the author of the book
     * @param title the title of the book
     * @param year the year the book was published
     * @param publisher the publisher of the book
     */
    public Book(String isbn, String title, String author,int year, String publisher) {
        this.author = new String(author);
        this.author.trim();
        this.isbn = new String(isbn);
        this.isbn.trim();
        this.publisher = new String(publisher);
        this.publisher.trim();
        this.title = new String(title);
        this.title.trim();
        this.year = year;
    }

     /**
       * Creates an object with the fields filled
       * @param aBook an existing Book object
     */
    public Book(Book aBook) {
        this(aBook.isbn, aBook.title, aBook.author, aBook.year, aBook.publisher);
    }

    /**
     * @return the ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the ISBN to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Generates a String representing the Book object
     * @return returns the String representing the Book
     */
    public String toString() {
        String str = "";
        str += "ISBN: " + isbn + "\n";
        str += "Title: " + title + "\n";
        str += "Author: " + author + "\n";
        str += "Year Published: " + year + "\n";
        str += "Publisher: " + publisher;
        return str;
    }

    /**
     * Determines if two Book objects have the same contents
     * @param obj the Object to compare to
     * @return returns whether the Books are the same (they should have the same isbn)
     */
    public boolean equals(Object obj) {
        if (this == obj) // are they the same object?
            return true;
        if (obj == null) // is the other one even an object?
            return false;
        if (!(obj instanceof Book)) // are they not both the same type?
            return false;
        Book other = (Book) obj; // now we know it's a Book
        return (isbn.equals(other.isbn));
    }

    /**
     * Compares this Book with arg0, using the ISBN
     * @param arg0 the Book to compare to
     * @return negative if this Book precedes arg0, zero if they are equal, positive if this Book follows arg0
     */
    public int compareTo(Book arg0) {
        return isbn.compareTo(arg0.isbn);
    }

    public int hashCode() {
		int size = 300151;
    	int[] primes = {5003, 5009, 5011, 5021, 5023, 104499, 100103, 100333, 100189, 100343};
		// int[] primes = {104933, 100613, 102019, 103813, 103967, 104499, 100103, 100333, 100189, 100343};
		int result = 0;;
		for (int i = 0; i < isbn.length(); i++){
			result += primes[i] * isbn.charAt(i);
		}
        return result % size;
    }
}
