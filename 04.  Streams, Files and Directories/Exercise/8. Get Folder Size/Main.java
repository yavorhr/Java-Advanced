import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String folderPath = "E:\\1. SoftUni\\Code\\Java\\03. Java Advanced\\Advanced\\04. Streams, Files And Directories - Lab\\Exercise\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";

        File folder = new File(folderPath);
        long totalSize = getLengthInBytes(folder);

        System.out.println(totalSize);
    }

    private static long getLengthInBytes(File folder) {
        long size = 0;

        for (File file : folder.listFiles()) {
            size += file.length();
        }
        return size;
    }
}

