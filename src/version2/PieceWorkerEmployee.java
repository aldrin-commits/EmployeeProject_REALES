/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

public class PieceWorkerEmployee {

    private int empID;
    private String empName;
    private int totalPiecesFinished;
    private double ratePerPiece;

    // default constructor
    public PieceWorkerEmployee() {
        empID = 0;
        empName = "N/A";
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }

    // partial constructor
    public PieceWorkerEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    // full constructor
    public PieceWorkerEmployee(int empID, String empName,
                               int totalPiecesFinished,
                               double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    // getter for employee id
    public int getEmpID() {
        return empID;
    }

    // setter for employee id
    public void setEmpID(int empID) {
        this.empID = empID;
    }

    // getter for employee name
    public String getEmpName() {
        return empName;
    }

    // setter for employee name
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    // getter for total pieces finished
    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    // setter for total pieces finished
    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) {
            this.totalPiecesFinished = totalPiecesFinished;
        }
    }

    // getter for rate per piece
    public double getRatePerPiece() {
        return ratePerPiece;
    }

    // setter for rate per piece
    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) {
            this.ratePerPiece = ratePerPiece;
        }
    }

    // calculates salary using piece rate and bonus
    public double computeSalary() {

        double basePay =
                totalPiecesFinished * ratePerPiece;

        int completeHundreds =
                totalPiecesFinished / 100;

        double bonusPay =
                completeHundreds * (10 * ratePerPiece);

        return basePay + bonusPay;
    }

    // displays the employee record without salary
    public void displayPieceWorkerEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | Pieces Finished: %d "
                + "| Rate/Piece: P%.2f%n",
                empID,
                empName,
                totalPiecesFinished,
                ratePerPiece
        );
    }

    // returns the employee information including salary
    @Override
    public String toString() {

        return String.format(
                "PieceWorkerEmployee [ID: %d, Name: %s, "
                + "Pieces: %d, Rate: P%.2f, Total Salary: P%.2f]",
                empID,
                empName,
                totalPiecesFinished,
                ratePerPiece,
                computeSalary()
        );
    }
}