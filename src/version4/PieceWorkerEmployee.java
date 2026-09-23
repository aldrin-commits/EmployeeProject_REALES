package version4;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate,
                               MyDate dateHired, int totalPiecesFinished,
                               double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }

    public double computeSalary() {
        double basePay = totalPiecesFinished * ratePerPiece;

        int completeHundreds = totalPiecesFinished / 100;
        double bonus = completeHundreds * (10 * ratePerPiece);

        return basePay + bonus;
    }

    public double computeSalary(int currentMonth) {
        double salary = computeSalary();

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    public void displayPieceWorkerEmployee() {
        displayEmployee();
        System.out.println("Total Pieces Finished: " + totalPiecesFinished);
        System.out.println("Rate Per Piece: ₱" + String.format("%.2f", ratePerPiece));
        System.out.println("Salary: ₱" + String.format("%.2f", computeSalary()));
    }

    @Override
    public String toString() {
        return "PieceWorkerEmployee{" +
                "empID=" + getEmpID() +
                ", empName=" + getEmpName() +
                ", birthDate=" + getBirthDate() +
                ", dateHired=" + getDateHired() +
                ", totalPiecesFinished=" + totalPiecesFinished +
                ", ratePerPiece=" + ratePerPiece +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PieceWorkerEmployee)) {
            return false;
        }

        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;

        return super.equals(other)
                && totalPiecesFinished == other.totalPiecesFinished
                && Double.compare(ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                totalPiecesFinished,
                ratePerPiece
        );
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}
