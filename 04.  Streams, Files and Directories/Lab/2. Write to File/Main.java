import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\YavorHr\\Desktop\\Demo\\src\\input.txt";

        FileInputStream inputStream = new FileInputStream(filePath);

        Scanner scanner = new Scanner(inputStream);

        String table = ",.!?";

        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);
                if (!table.contains(String.valueOf(currentSymbol))) {
                    fileOutputStream.write(currentSymbol);
                }
            }
            fileOutputStream.write('\n');
        }

    }
}
