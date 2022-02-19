import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Path pathfile = Path.of("C:\\Users\\YavorHr\\Documents\\1. SoftUni\\Advanced\\4. Streams, Files And Directories - Lab\\УПР\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");
        List<String> lines = Files.readAllLines(pathfile);

        PrintWriter writer = new PrintWriter("outputLines.txt");
        int row = 1;
        for (String line : lines) {
            writer.println(row++ + ". " + line);
        }
        writer.close();
    }
}















