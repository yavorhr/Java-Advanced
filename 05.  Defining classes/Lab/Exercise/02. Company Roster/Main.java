import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Department> departments = new HashMap<String, Department>(); //име на отдел -> ОТДЕЛ (име, служители)
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            Employee employee;
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            //6 parameters
            if(input.length == 6) {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position,department, email, age);
            }
            //4 parameters
            else if (input.length == 4) {
                employee = new Employee(name, salary, position, department);
            }
            //5 parameters
            else {
                try {
                    int age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, department, age);
                } catch (NumberFormatException e) {
                    String email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }

            //служителя -> отдел
            departments.putIfAbsent(department, new Department(department)); //създаваме си нов отдел
            departments.get(department).getEmployees().add(employee);
        }

        //Излизайки от for-цикъла имаме : име на отдела -> отдел (служители)

        Department maxAverageSalaryDepartment  = departments.entrySet()
                .stream()
                //кой е отдела с максимална средна заплата ? Взимаме отдела
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                //с .get() взимаме отдела (entry-то) с максимална средна заплата, който изчислихме с .max();
                .get()
                //от това entry ми дай средната заплата
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));
    }
}
