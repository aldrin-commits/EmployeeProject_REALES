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

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) {
            this.totalPiecesFinished = totalPiecesFinished;
        }
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) {
            this.ratePerPiece = ratePerPiece;
        }
    }

    public double computeSalary() {

        double basePay =
                totalPiecesFinished * ratePerPiece;

        int completeHundreds =
                totalPiecesFinished / 100;

        double bonusPay =
                completeHundreds * (10 * ratePerPiece);

        return basePay + bonusPay;
    }

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