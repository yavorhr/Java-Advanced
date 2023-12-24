import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\YavorHr\\Desktop\\Demo\\input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        BufferedWriter writer = new BufferedWriter(new FileWriter("05. WriteEveryThirdLine.txt"));

        Stream<String> inputLines = reader.lines();
        List<String> linesList = inputLines.collect(Collectors.toList());

        WriteEveryThirdLine(writer, linesList);

        writer.close();
    }

    private static void WriteEveryThirdLine(BufferedWriter writer, List<String> linesList) throws IOException {
        for (int i = 0; i < linesList.size(); i+=3) {
            if (i % 3 == 0) {
                writer.write(linesList.get(i));
                writer.newLine();
            }
        }
    }

}

