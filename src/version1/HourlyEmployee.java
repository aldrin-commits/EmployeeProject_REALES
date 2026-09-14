/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version1;

public class HourlyEmployee {

    // private attributes
    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;

    // default constructor
    public HourlyEmployee() {
        empID = 0;
        empName = "N/A";
        totalHoursWorked = 0;
        ratePerHour = 0;
    }

    // partial constructor
    public HourlyEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    // full constructor
    public HourlyEmployee(int empID, String empName,
                          float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    // getter for empID
    public int getEmpID() {
        return empID;
    }

    // setter for empID
    public void setEmpID(int empID) {
        this.empID = empID;
    }

    // getter for empName
    public String getEmpName() {
        return empName;
    }

    // setter for empName
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    // getter for totalHoursWorked
    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    // setter for totalHoursWorked
    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    // getter for ratePerHour
    public double getRatePerHour() {
        return ratePerHour;
    }

    // setter for ratePerHour
    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        }
    }

    // calculates the employee's salary including overtime
    public double computeSalary() {

        if (totalHoursWorked <= 40) {

            return totalHoursWorked * ratePerHour;

        } else {

            double regularPay = 40 * ratePerHour;

            double overtimeHours = totalHoursWorked - 40;

            double overtimePay = overtimeHours * (ratePerHour * 1.5);

            return regularPay + overtimePay;
        }
    }

    // displays employee information without the computed salary
    public void displayHourlyEmployee() {

        System.out.printf(
            "ID: %d | Name: %s | Hours: %.2f | Rate: P%.2f/hr%n",
            empID, 
            empName,
            totalHoursWorked,
            ratePerHour
        );
    }

    // returns the employee information including the computed salary
    @Override
    public String toString() {

        return String.format(
            "HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, Rate: P%.2f, Total Salary: P%.2f]",
            empID,
            empName,
            totalHoursWorked,
            ratePerHour,
            computeSalary()
        );
    }
}
