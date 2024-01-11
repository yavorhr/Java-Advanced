import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... strings) {
        setTitle(title);
        setYear(year);
        setAuthors(Arrays.asList(strings));
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s", this.title, this.year, getAuthorsToString(this.authors));
    }

    private String getAuthorsToString(List<String> authors) {
        return String.join(", ", authors);
    }

    @Override
    public int compareTo(Book otherBook) {
        int result = this.title.compareTo(otherBook.title);
        if (result == 0) {
            result = Integer.compare(this.year, otherBook.year);
        }
        return result;
    }
}
