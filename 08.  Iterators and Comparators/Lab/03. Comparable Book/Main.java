import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        if (bookOne.compareTo(bookTwo) > 0) {
            System.out.printf("%s is before %s\n", bookOne, bookTwo);
        } else if (bookOne.compareTo(bookTwo) < 0) {
            System.out.printf("%s is before %s\n", bookTwo, bookOne);
        } else {
            System.out.println("Book are equal");
        }

        List<Book> books = new ArrayList<>();

        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        //sort by the compareTo() method
        Collections.sort(books);

        System.out.println();
    }
}


