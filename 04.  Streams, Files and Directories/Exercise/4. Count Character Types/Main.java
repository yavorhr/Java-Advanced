import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";

        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationsCount = 0;

        String vowels = "aeiou";
        String punctuations = "!?.,";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = bufferedReader.readLine();

        while (line != null) {
            String[] words = line.split("\\s+");
            for (String currentWord : words) {
                for (char currentChar : currentWord.toCharArray()) {
                    String currentCharAsString = String.valueOf(currentChar);
                    if (vowels.contains(currentCharAsString)) {
                        vowelsCount++;
                    } else if (punctuations.contains(currentCharAsString)) {
                        punctuationsCount++;
                    } else {
                        consonantsCount++;
                    }
                }
            }
            line = bufferedReader.readLine();
        }

        writeResultToFile(vowelsCount, consonantsCount, punctuationsCount);
    }

    private static void writeResultToFile(int vowelsCount, int consonantsCount, int punctuationsCount) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("output.txt");
        printWriter.println("Vowels: " + vowelsCount);
        printWriter.println("Consonants: " + consonantsCount);
        printWriter.println("Punctuation: " + punctuationsCount);

        printWriter.close();
    }
}

