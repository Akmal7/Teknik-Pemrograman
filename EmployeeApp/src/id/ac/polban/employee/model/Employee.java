package id.ac.polban.employee.model;

public class Employee {
    private static int nextId = 1;          // Untuk auto increment ID
    private static int totalEmployees = 0;  // Untuk menghitung total employee

    private int id;
    private String name;
    private Department department;
    private EmploymentType type;
    private double salary;

    public Employee(String name, Department department,
                    EmploymentType type, double salary) {

        this.id = nextId++;     // ID otomatis
        this.name = name;
        this.department = department;
        this.type = type;
        this.salary = salary;

        totalEmployees++;      // Hitung total employee
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmploymentType getType() {
        return type;
    }

    public void setType(EmploymentType type) {
        this.type = type;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static int getNextId() {
        return nextId;
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }

    public static void resetIdCounter() {
        nextId = 1;
        totalEmployees = 0;
    }
}