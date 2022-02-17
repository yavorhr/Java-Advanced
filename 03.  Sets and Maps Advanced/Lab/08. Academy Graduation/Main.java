import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String, Double> studentGrades = new TreeMap<>();
        int studentNumbers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < studentNumbers; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            double sum = 0;

            for (Double grade : grades) {
                sum += grade;
            }

            double avg = sum / grades.size();
            studentGrades.putIfAbsent(name,avg );

        }
        studentGrades.entrySet().
                forEach(entry -> System.out.println(String.format("%s is graduated with " + entry.getValue(), entry.getKey())));

    }
}












