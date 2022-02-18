
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = "C:\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);

        String table = ",.!?";

        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        int nextByte = inputStream.read();
        while (nextByte != -1) {
            if (nextByte == ' ' || nextByte == '\n') {
                fileOutputStream.write(nextByte);
            } else {
                fileOutputStream.write(String.valueOf(nextByte).getBytes());
            }
            nextByte = inputStream.read();
        }
        fileOutputStream.close();
    }
}


