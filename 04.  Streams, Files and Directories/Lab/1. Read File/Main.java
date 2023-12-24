import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        String filePath = "C:\\Users\\YavorHr\\Desktop\\Demo\\src\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            int oneByte = inputStream.read();

            printASCIItoBinary(inputStream, oneByte);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printASCIItoBinary(FileInputStream inputStream, int oneByte) throws IOException {
        while (oneByte != -1) {
            System.out.print(Integer.toBinaryString(oneByte) + " ");
            oneByte = inputStream.read();
        }
    }
}
