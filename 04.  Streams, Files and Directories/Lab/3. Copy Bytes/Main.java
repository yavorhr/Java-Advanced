import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\YavorHr\\Desktop\\Demo\\src\\input.txt";
        FileInputStream inputStream = new FileInputStream(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        int nextByte = inputStream.read();
        while (nextByte != -1) {
            if (nextByte == ' ' || nextByte == '\n') {
                //add ASCII for ' ' or ||
                fileOutputStream.write(nextByte);
            } else {
                //add binary code for rest
                fileOutputStream.write(String.valueOf(nextByte).getBytes());
            }
            nextByte = inputStream.read();
        }

        fileOutputStream.close();
        inputStream.close();
    }
}
