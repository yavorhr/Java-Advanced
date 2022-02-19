import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String pathfile = "C:\\Users\\YavorHr\\Documents\\1. SoftUni\\Advanced" +
                "\\4. Streams, Files And Directories - Lab\\УПР\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        int countVowels = 0;
        int consonants = 0;
        int countPunctuation = 0;

        String vowels = "aeiou";
        String punctuation = "!?.,";
        BufferedReader reader = new BufferedReader(new FileReader(pathfile));
        String line = reader.readLine();
        while (line != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                for (char symbol : word.toCharArray()) {
                    String charAsString = String.valueOf(symbol);
                    if (vowels.contains(charAsString)) {
                        countVowels++;
                    } else if (punctuation.contains(charAsString)) {
                        countPunctuation++;
                    } else {
                        consonants++;
                    }
                }
            }

            line = reader.readLine();

        }
        reader.close();

        PrintWriter writer = new PrintWriter("outputCount.txt");
        writer.println("Vowels: " + countVowels);
        writer.println("Consonants: " + consonants);
        writer.println("Punctuation: " + countPunctuation);

        writer.close();
    }
}













