import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\YavorHr\\Documents\\1. SoftUni\\Advanced\\4. Streams, Files And Directories - Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Deque<File> deque = new ArrayDeque<>();
        deque.add(file);
        int count = 1;

        while (!deque.isEmpty()) {
            File f = deque.poll();
            count++;
            System.out.println(f.getName());

            File[] files = file.listFiles();
            for (File innerFile : files) {
                if (innerFile.isDirectory()) {
                    deque.offer(innerFile);
                }
            }
        }
        System.out.println(count);
    }
}








