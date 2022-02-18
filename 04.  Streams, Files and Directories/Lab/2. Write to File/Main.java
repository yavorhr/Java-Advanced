import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {

        String path = "C:\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(inputStream);

        String table = ",.!?";

        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if (!table.contains(String.valueOf(symbol))) {
                    fileOutputStream.write(symbol);
                }
            }
            fileOutputStream.write('\n');
        }
    }
}

