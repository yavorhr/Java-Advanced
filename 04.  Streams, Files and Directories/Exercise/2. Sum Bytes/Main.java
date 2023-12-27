import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("input.txt");
        byte[] bytes = Files.readAllBytes(path);

        int sum = getBytesSum(bytes);
        printTotalBytes(sum);
    }

    private static void printTotalBytes(int sum) {
        System.out.println(sum);
    }

    private static int getBytesSum(byte[] bytes) {
        int sum = 0;
        for (byte aByte : bytes) {
            if (aByte != 10 && aByte != 13) {
                sum += aByte;
            }
        }
        return sum;
    }


}

