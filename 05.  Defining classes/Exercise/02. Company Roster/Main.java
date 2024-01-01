import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        HashMap<String, Department> departmentHashMap = new HashMap<>();

        while (n > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String departmentName = tokens[3];

            Employee employee = createEmployee(tokens);

            departmentHashMap.putIfAbsent(departmentName, new Department(departmentName));
            departmentHashMap.get(departmentName).getEmployeeList().add(employee);

            n--;
        }

        Department bestPaidDepartment = departmentHashMap
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(d -> d.getValue().getAverageSalary()))
                //get Map<String, Department>
                .get()
                //get only Department as value from the map
                .getValue();

        printBestDepartment(bestPaidDepartment);
    }

    private static void printBestDepartment(Department bestPaidDepartment) {
        System.out.println("Highest Average Salary: " + bestPaidDepartment.getName());
        bestPaidDepartment.getEmployeeList()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(e -> System.out.println(e.toString()));
    }

    private static Employee createEmployee(String[] tokens) {
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        String position = tokens[2];
        String departmentName = tokens[3];

        Employee employee = new Employee(name, salary, position, departmentName);

        if (tokens.length == 5) {
            String email = tokens[4];
            employee.setEmail(email);
        } else if (tokens.length == 6) {
            String email = tokens[4];
            int age = Integer.parseInt(tokens[5]);
            employee.setEmail(email);
            employee.setAge(age);
        }

        return employee;
    }
}


