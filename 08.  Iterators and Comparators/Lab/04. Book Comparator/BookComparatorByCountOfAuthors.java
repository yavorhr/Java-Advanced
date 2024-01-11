import java.util.Comparator;

public class BookComparatorByCountOfAuthors implements Comparator<Book>{
    @Override
    public int compare(Book firstBook, Book secondBook) {
        return firstBook.getAuthors().size() - secondBook.getAuthors().size();

    }
}
