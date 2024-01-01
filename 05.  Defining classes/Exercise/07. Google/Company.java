public class Company {
    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public Company setDepartment(String department) {
        this.department = department;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public Company setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", getName(), getDepartment(), getSalary());
    }
}
