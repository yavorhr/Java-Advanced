import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        File rootFolder = new File("E:\\1. SoftUni\\Code\\Java\\" +
                "03. Java Advanced\\Advanced\\" +
                "04. Streams, Files And Directories - Lab\\LAB\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\" +
                "Files-and-Streams");

        Deque<File> dirs = new ArrayDeque<>();

        dirs.add(rootFolder);

        int count = 0;

        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles)
                if (nestedFile.isDirectory())
                    dirs.offer(nestedFile);
            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");

    }
}

