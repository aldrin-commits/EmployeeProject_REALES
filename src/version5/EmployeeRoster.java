package version5;

import java.util.ArrayList;

public class EmployeeRoster {

    private ArrayList<Employee> empList;

    // Default constructor
    public EmployeeRoster() {
        this.empList = new ArrayList<>();
    }

    // Constructor with initial capacity
    public EmployeeRoster(int initialCapacity) {
        this.empList = new ArrayList<>(initialCapacity);
    }

    // Add employee
    public boolean addEmployee(Employee emp) {

        if (emp == null) {
            return false;
        }

        return empList.add(emp);
    }

    // Remove employee by ID
    public Employee removeEmployee(int empID) {

        for (int i = 0; i < empList.size(); i++) {

            Employee emp = empList.get(i);

            if (emp.getEmpID() == empID) {

                return empList.remove(i);
            }
        }

        return null;
    }

    // Search employee by ID
    public Employee searchEmployee(int empID) {

        for (Employee emp : empList) {

            if (emp.getEmpID() == empID) {
                return emp;
            }
        }

        return null;
    }

    // Return number of employees
    public int countEmployees() {
        return empList.size();
    }

    // Count Hourly Employees
    public int countHE() {

        int total = 0;

        for (Employee emp : empList) {

            if (emp instanceof HourlyEmployee) {
                total++;
            }
        }

        return total;
    }

    // Count Piece Worker Employees
    public int countPWE() {

        int total = 0;

        for (Employee emp : empList) {

            if (emp instanceof PieceWorkerEmployee) {
                total++;
            }
        }

        return total;
    }

    // Count Commission Employees
    public int countCE() {

        int total = 0;

        for (Employee emp : empList) {

            if (emp instanceof CommissionEmployee
                    && !(emp instanceof BasePlusCommissionEmployee)) {

                total++;
            }
        }

        return total;
    }

    // Count Base Plus Commission Employees
    public int countBPCE() {

        int total = 0;

        for (Employee emp : empList) {

            if (emp instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }

        return total;
    }

    // Display payroll using PURE POLYMORPHISM
    public void displayPayroll(int currentMonth) {

        for (Employee emp : empList) {

            double salary =
                    emp.computeSalary(currentMonth);

            System.out.printf(
                    "ID: %d | Name: %s | Pay: ₱%,.2f%n",
                    emp.getEmpID(),
                    emp.getEmpName(),
                    salary
            );
        }
    }

    // Display all employees
    public void displayAllEmployees() {

        for (Employee emp : empList) {

            System.out.println(emp);
        }
    }
}