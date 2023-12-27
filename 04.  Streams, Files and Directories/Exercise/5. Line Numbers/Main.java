import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("inputLineNumbers.txt");

        List<String> lines = Files.readAllLines(filePath);

        writeResultToFile(lines);
    }

    private static void writeResultToFile(List<String> lines) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("output.txt");

        int row = 1;
        for (String line: lines) {
            printWriter.println(String.format("%d. %s", row++, line));
        }
        printWriter.close();
    }
}

