import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("input.txt");

        List<String> lines = Files.readAllLines(path);

        printASCIIsumPerLine(lines);
    }

    private static void printASCIIsumPerLine(List<String> lines) {
        lines.stream().map(String::toCharArray).forEach(charArr -> {
            int sum = 0;
            for (char symbol : charArr) {
                sum += symbol;
            }
            System.out.println(sum);
        });
    }
}

