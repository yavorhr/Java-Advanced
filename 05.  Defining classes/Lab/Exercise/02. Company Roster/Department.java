import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employeeList;
    private String name;

    public Department(String department) {
        this.name = department;
        this.employeeList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public Department setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Department setName(String name) {
        this.name = name;
        return this;
    }

    public double getAverageSalary(){
        return employeeList
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }
}
