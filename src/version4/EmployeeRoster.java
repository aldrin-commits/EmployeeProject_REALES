package version4;

public class EmployeeRoster {

    private Employee[] empList;
    private int max;
    private int count;

    // Default constructor
    public EmployeeRoster() {
        this.max = 10;
        this.empList = new Employee[this.max];
        this.count = 0;
    }

    // Custom capacity constructor
    public EmployeeRoster(int max) {
        this.max = max;
        this.empList = new Employee[this.max];
        this.count = 0;
    }

    // Getters
    public Employee[] getEmpList() {
        return empList;
    }

    public int getMax() {
        return max;
    }

    public int getCount() {
        return count;
    }

    // Add employee
    public boolean addEmployee(Employee emp) {

        if (emp == null || count >= max) {
            return false;
        }

        empList[count] = emp;
        count++;

        return true;
    }

    // Remove employee
    public Employee removeEmployee(int empID) {

        for (int i = 0; i < count; i++) {

            if (empList[i].getEmpID() == empID) {

                Employee removedEmployee = empList[i];

                // Shift all employees after the removed employee
                // one position to the left.
                for (int j = i; j < count - 1; j++) {
                    empList[j] = empList[j + 1];
                }

                // Clear the last active position
                empList[count - 1] = null;

                count--;

                return removedEmployee;
            }
        }

        return null;
    }

    // Search employee by ID
    public Employee searchEmployee(int empID) {

        for (int i = 0; i < count; i++) {

            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        }

        return null;
    }

    // Count Hourly Employees
    public int countHE() {

        int total = 0;

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof HourlyEmployee) {
                total++;
            }
        }

        return total;
    }

    // Count Piece Worker Employees
    public int countPWE() {

        int total = 0;

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof PieceWorkerEmployee) {
                total++;
            }
        }

        return total;
    }

    // Count Commission Employees
    // BasePlusCommissionEmployee is NOT counted here.
    public int countCE() {

        int total = 0;

        for (int i = 0; i < count; i++) {

            if (empList[i].getClass() == CommissionEmployee.class) {
                total++;
            }
        }

        return total;
    }

    // Count Base Plus Commission Employees
    public int countBPCE() {

        int total = 0;

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }

        return total;
    }

    // Display Hourly Employees
    public void displayHE() {

        System.out.println("\n=== HOURLY EMPLOYEES ===");

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof HourlyEmployee) {

                HourlyEmployee employee =
                        (HourlyEmployee) empList[i];

                employee.displayHourlyEmployee();
                System.out.println();
            }
        }
    }

    // Display Piece Worker Employees
    public void displayPWE() {

        System.out.println("\n=== PIECE WORKER EMPLOYEES ===");

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof PieceWorkerEmployee) {

                PieceWorkerEmployee employee =
                        (PieceWorkerEmployee) empList[i];

                employee.displayPieceWorkerEmployee();
                System.out.println();
            }
        }
    }

    // Display Commission Employees
    // Only pure CommissionEmployee objects.
    public void displayCE() {

        System.out.println("\n=== COMMISSION EMPLOYEES ===");

        for (int i = 0; i < count; i++) {

            if (empList[i].getClass() == CommissionEmployee.class) {

                CommissionEmployee employee =
                        (CommissionEmployee) empList[i];

                employee.displayCommissionEmployee();
                System.out.println();
            }
        }
    }

    // Display Base Plus Commission Employees
    public void displayBPCE() {

        System.out.println("\n=== BASE PLUS COMMISSION EMPLOYEES ===");

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof BasePlusCommissionEmployee) {

                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee) empList[i];

                employee.displayBasePlusCommissionEmployee();
                System.out.println();
            }
        }
    }

    // Display all employees
    public void displayAllEmployees() {

        System.out.println("\n=== ALL EMPLOYEES ===");

        for (int i = 0; i < count; i++) {

            Employee employee = empList[i];

            System.out.println(
                    "ID: " + employee.getEmpID()
                            + " | Name: " + employee.getEmpName().displayName()
                            + " | Type: " + employee.getClass().getSimpleName()
            );
        }

        System.out.println("Total Employees: " + count + "/" + max);
    }

    // Display payroll
    public void displayPayroll(int currentMonth) {

        System.out.println("\n=== PAYROLL REPORT ===");

        for (int i = 0; i < count; i++) {

            Employee employee = empList[i];

            double regularSalary;
            double finalSalary;

            String employeeType;

            /*
             * IMPORTANT:
             *
             * BasePlusCommissionEmployee must be checked
             * BEFORE CommissionEmployee because BasePlus
             * is also a CommissionEmployee.
             */

            if (employee instanceof BasePlusCommissionEmployee) {

                BasePlusCommissionEmployee bpce =
                        (BasePlusCommissionEmployee) employee;

                regularSalary = bpce.computeSalary();
                finalSalary = bpce.computeSalary(currentMonth);

                employeeType = "BasePlusCommissionEmployee";

            } else if (employee instanceof HourlyEmployee) {

                HourlyEmployee hourly =
                        (HourlyEmployee) employee;

                regularSalary = hourly.computeSalary();
                finalSalary = hourly.computeSalary(currentMonth);

                employeeType = "HourlyEmployee";

            } else if (employee instanceof PieceWorkerEmployee) {

                PieceWorkerEmployee piece =
                        (PieceWorkerEmployee) employee;

                regularSalary = piece.computeSalary();
                finalSalary = piece.computeSalary(currentMonth);

                employeeType = "PieceWorkerEmployee";

            } else if (employee.getClass() == CommissionEmployee.class) {

                CommissionEmployee commission =
                        (CommissionEmployee) employee;

                regularSalary = commission.computeSalary();
                finalSalary = commission.computeSalary(currentMonth);

                employeeType = "CommissionEmployee";

            } else {

                System.out.println(
                        "Unsupported employee type: "
                                + employee.getClass().getSimpleName()
                );

                continue;
            }

            boolean birthdayBonus =
                    finalSalary > regularSalary;

            System.out.printf(
                    "ID: %d | Name: %s | Type: %s | Salary: ₱%.2f",
                    employee.getEmpID(),
                    employee.getEmpName().displayName(),
                    employeeType,
                    finalSalary
            );

            if (birthdayBonus) {
                System.out.print(" | Birthday Bonus Applied");
            } else {
                System.out.print(" | No Birthday Bonus");
            }

            System.out.println();
        }
    }
}
