import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\YavorHr\\Desktop\\Demo\\Files-and-Streams");
        File[] files = file.listFiles();

        for (File f : files) {
            printFileNameAndLength(f);
        }

    }

    private static void printFileNameAndLength(File f) {
        if (!f.isDirectory()) {
            System.out.printf("%s: [%s]%n",
                    f.getName(), f.length());

        }
    }
}

