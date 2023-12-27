import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("input.txt");
        List<String> lines = Files.readAllLines(path);

        writeCapitalizedLines(lines);
    }

    private static void writeCapitalizedLines(List<String> lines) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("output.txt");

        for (String line : lines) {
            printWriter.println( line.toUpperCase());
        }

        printWriter.close();
    }
}

