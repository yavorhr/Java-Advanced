import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    private final class LibIterator implements Iterator<Book> {
        private int index;

        public LibIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < books.length;
        }

        @Override
        public Book next() {
            Book book = books[this.index];
            this.index++;
            return book;
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
}
