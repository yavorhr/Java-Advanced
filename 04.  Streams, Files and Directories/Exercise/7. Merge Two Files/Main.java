import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> firstFileList = readDataFromFile("inputOne.txt");
        List<String> secondFileList = readDataFromFile("inputTwo.txt");

        List<String> mergedLists = mergeListsData(firstFileList, secondFileList);

        writeOutputToFile(mergedLists);
    }

    private static void writeOutputToFile(List<String> outputList) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("output.txt");
        outputList.forEach(printWriter::println);

        printWriter.close();
    }

    private static List<String> readDataFromFile(String path) throws IOException {
        Path firstPath = Path.of("inputOne.txt");
        return Files.readAllLines(firstPath);
    }

    private static List<String> mergeListsData(List<String> firstFileList, List<String> secondFileList) {
        List<String> outputList = new ArrayList<>();

        outputList.addAll(firstFileList);
        outputList.addAll(secondFileList);

        return outputList;
    }
}

