import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Path firstPath = Path.of("C:\\Users\\YavorHr\\Documents\\1. SoftUni\\Advanced\\4. Streams, Files And Directories - Lab\\УПР\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        List<String> linesFirstFile = Files.readAllLines(firstPath);

        Path secondPath = Path.of("C:\\Users\\YavorHr\\Documents\\1. SoftUni\\Advanced\\4. Streams, Files And Directories - Lab\\УПР\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        List<String> linesSecondFile = Files.readAllLines(secondPath);

        PrintWriter writer = new PrintWriter("merge.txt");
        linesFirstFile.forEach(writer::println);
        linesSecondFile.forEach(writer::println);

        writer.close();
    }
}

















