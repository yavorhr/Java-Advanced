import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        Path pathfile = Path.of("C:\\Users\\YavorHr\\Documents\\1. SoftUni\\Advanced" +
                "\\4. Streams, Files And Directories - Lab\\УПР\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        long sum = 0;
        byte[] bytes = Files.readAllBytes(pathfile);

        for (byte aByte : bytes) {
            if (aByte == 10 || aByte == 13) {
                continue;
            }
            sum += aByte;
        }

        System.out.println(sum);
    }
}









