import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\Users\\YavorHr\\Desktop\\Demo\\input.txt");
        Path output = Paths.get("06. Sort Lines.txt");

        try {
            List<String> lines = Files.readAllLines(path);
            lines = lines.stream().filter(l -> !l.isBlank()).collect(Collectors.toList());
            Collections.sort(lines);
            Files.write(output, lines);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

