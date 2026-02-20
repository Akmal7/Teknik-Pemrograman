import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class Main{
    public static void main(String[] args) {

        Department d = new Department("Information Technology");
        EmploymentType t = new EmploymentType("Full Time");

        Employee e = new Employee("Akmal", d, t, 7000000);

        EmployeeService service = new EmployeeService();
        service.addEmployee(e);

        System.out.println("Nama: " + e.getName());
        System.out.println("Gaji: " + e.getSalary());
        System.out.println("Total Employee: " + Employee.getTotalEmployees());
    }
}