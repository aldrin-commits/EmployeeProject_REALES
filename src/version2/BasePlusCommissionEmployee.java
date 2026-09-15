/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

public class BasePlusCommissionEmployee {

    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        empID = 0;
        empName = "N/A";
        totalSale = 0;
        baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, String empName,
                                      double totalSale,
                                      double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
    }

    public int getEmpID() { return empID; }
    public void setEmpID(int empID) { this.empID = empID; }
    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }
    public double getTotalSale() { return totalSale; }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) this.totalSale = totalSale;
    }

    public double getBaseSalary() { return baseSalary; }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) this.baseSalary = baseSalary;
    }

    public double computeSalary() {
        double commissionRate;
        if (totalSale < 50000) commissionRate = 0.05;
        else if (totalSale < 100000) commissionRate = 0.10;
        else if (totalSale < 500000) commissionRate = 0.15;
        else commissionRate = 0.20;
        return baseSalary + (totalSale * commissionRate);
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | Total Sale: P%.2f | Base Salary: P%.2f%n",
                empID, empName, totalSale, baseSalary
        );
    }

    @Override
    public String toString() {
        double commissionRate;
        if (totalSale < 50000) commissionRate = 0.05;
        else if (totalSale < 100000) commissionRate = 0.10;
        else if (totalSale < 500000) commissionRate = 0.15;
        else commissionRate = 0.20;

        return String.format(
                "BasePlusCommissionEmployee [ID: %d, Name: %s, Sales: P%.2f, "
                + "Base Salary: P%.2f, Commission Rate: %.0f%%, Total Salary: P%.2f]",
                empID, empName, totalSale, baseSalary,
                commissionRate * 100, computeSalary()
        );
    }
}