import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = Arrays.asList(authors);
    }


    @Override
    public int compareTo(Book otherBook) {
        int result = this.getTitle().compareTo(otherBook.getTitle());
        if (result==0) {
            result = Integer.compare(this.year,otherBook.year);
        }
        return result;
    }

    public String getTitle() {
        return this.title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public void setAuthors(String... authors) {
        this.authors = Arrays.asList(authors);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

}
