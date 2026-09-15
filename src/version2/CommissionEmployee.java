/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

public class CommissionEmployee {

    private int empID;
    private String empName;
    private double totalSale;

    // default constructor
    public CommissionEmployee() {
        empID = 0;
        empName = "N/A";
        totalSale = 0;
    }

    // partial constructor
    public CommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0;
    }

    // full constructor
    public CommissionEmployee(int empID, String empName,
                              double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        }
    }

    public double computeSalary() {

        double commissionRate;

        if (totalSale < 50000) {
            commissionRate = 0.05;
        } else if (totalSale < 100000) {
            commissionRate = 0.10;
        } else if (totalSale < 500000) {
            commissionRate = 0.15;
        } else {
            commissionRate = 0.20;
        }

        return totalSale * commissionRate;
    }

    public void displayCommissionEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | Total Sale: P%.2f%n",
                empID,
                empName,
                totalSale
        );
    }

    @Override
    public String toString() {

        return String.format(
                "CommissionEmployee [ID: %d, Name: %s, "
                + "Total Sale: P%.2f, Commission Salary: P%.2f]",
                empID,
                empName,
                totalSale,
                computeSalary()
        );
    }
}