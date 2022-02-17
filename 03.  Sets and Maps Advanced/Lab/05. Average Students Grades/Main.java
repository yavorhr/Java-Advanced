import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> grades = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String studentName = input[0];
            double studentGrade = Double.parseDouble(input[1]);

            grades.putIfAbsent(studentName, new ArrayList<>());
            if (grades.containsKey(studentName)) {
                List<Double> currentGrades = grades.get(studentName);
                currentGrades.add(studentGrade);
                grades.put(studentName, currentGrades);
            }
        }

        for (Map.Entry<String, List<Double>> entry : grades.entrySet()) {
            System.out.println(String.format("%s -> %s (avg: %.2f)",
                    entry.getKey(),
                    gradesAsString (entry.getValue()),
                    avgGrade(entry.getValue())));
        }
    }

    private static Double avgGrade(List<Double> grades) {
        return grades.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.00);
    }

    private static String gradesAsString(List<Double> grades) {
        return  grades.stream()
                .map(grade -> String.format("%.2f",grade))
                .collect(Collectors.joining(" "));
    }
}





