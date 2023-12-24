import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\YavorHr\\Desktop\\Demo\\input.txt";
        Scanner scanner = new Scanner(new FileInputStream(path));

        PrintWriter writer = new PrintWriter("integers-out.txt");

        while (scanner.hasNext()) {

            writeIntToFile(scanner, writer);

            scanner.next();
        }

        writer.close();
    }

    private static void writeIntToFile(Scanner scanner, PrintWriter writer) {
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            writer.println(number);
        }
    }
}

