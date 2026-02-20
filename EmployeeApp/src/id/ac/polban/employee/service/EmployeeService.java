package id.ac.polban.employee.service;
import id.ac.polban.employee.model.Employee;
import java.util.HashMap;
import java.util.Map;

public class EmployeeService {
   private Map<Integer, Employee> employees = new HashMap<>();

   public EmployeeService() {
   }

   public void addEmployee(Employee var1) {
      this.employees.put(var1.getId(), var1);
   }

   public Employee getEmployee(int var1) {
      return (Employee)this.employees.get(var1);
   }

   public void raiseSalary(int var1, double var2) {
      Employee var4 = (Employee)this.employees.get(var1);
      if (var4 != null) {
         var4.setSalary(var4.getSalary() * (1.0 + var2 / 100.0));
      }

   }
}