import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(path)) {
            int oneByte = fileStream.read();
            while (oneByte != -1 ) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fileStream.read();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}




















