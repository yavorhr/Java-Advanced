import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String folderPath = "C:\\Users\\YavorHr\\Documents\\1. SoftUni\\Advanced\\4. Streams, Files And Directories - Lab\\УПР\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(folderPath);

        long size = 0;
        for (File file : folder.listFiles()) {
            size += file.length();
        }

        System.out.println("Folder size: " + size);
    }
}


















