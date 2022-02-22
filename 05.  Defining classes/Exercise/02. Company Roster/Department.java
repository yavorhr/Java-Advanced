
import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department (String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    //изчисляваме средната заплата по отдели ->
    public double getAverageSalary() {
        //дай ми служителите на текущия отдел ->
        return this.employees
                .stream()
                //за всяко едно employee ми вземи заплатата
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    public String getName() {
        return this.name;
    }
}