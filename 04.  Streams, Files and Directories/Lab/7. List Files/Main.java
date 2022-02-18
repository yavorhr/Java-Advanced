
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\YavorHr\\Documents\\1. SoftUni\\Advanced\\4. Streams, Files And Directories - Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources");
        File[] files = file.listFiles();

        for (File f : files) {
            if (!f.isDirectory()) {
                System.out.println(f.length());
            }
        }

    }
}







