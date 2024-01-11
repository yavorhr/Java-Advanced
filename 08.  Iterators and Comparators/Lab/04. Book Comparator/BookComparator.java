import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        int result = firstBook.compareTo(secondBook);
        if (result == 0) {
            result = Integer.compare(firstBook.getYear(), secondBook.getYear());
        }
        return result;
    }
}
