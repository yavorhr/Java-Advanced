
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "C:\\input.txt";
        Scanner scanner = new Scanner(new FileInputStream(path));

        PrintWriter writer = new PrintWriter("integers-out.txt");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                writer.println(number);
            }
            scanner.next();
        }

        writer.close();
    }
}




