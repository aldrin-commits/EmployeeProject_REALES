package version3;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

    // Default constructor
    public PieceWorkerEmployee() {
        super();
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }

    // Full constructor
    public PieceWorkerEmployee(int empID,
                               Name empName,
                               MyDate birthDate,
                               MyDate dateHired,
                               int totalPiecesFinished,
                               double ratePerPiece) {

        super(empID, empName, birthDate, dateHired);

        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    // Getters
    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    // Setters
    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) {
            this.totalPiecesFinished = totalPiecesFinished;
        }
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) {
            this.ratePerPiece = ratePerPiece;
        }
    }

    // Salary
    @Override
    public double computeSalary() {

        double basePay =
                totalPiecesFinished * ratePerPiece;

        int completeHundreds =
                totalPiecesFinished / 100;

        double bonusPay =
                completeHundreds * (10 * ratePerPiece);

        return basePay + bonusPay;
    }

    // Salary with birthday bonus
    @Override
    public double computeSalary(int currentMonth) {

        double basePay = computeSalary();

        return basePay + super.computeSalary(currentMonth);
    }

    // Display
    public void displayPieceWorkerEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | DOB: %s | Hired: %s "
                        + "| Pieces: %d | Rate/Piece: ₱%.2f%n",
                getEmpID(),
                getEmpName(),
                getBirthDate(),
                getDateHired(),
                totalPiecesFinished,
                ratePerPiece
        );
    }

    // toString
    @Override
    public String toString() {

        return String.format(
                "PieceWorkerEmployee [ID: %d, Name: %s, "
                        + "DOB: %s, Hired: %s, Pieces: %d, "
                        + "Rate: ₱%.2f, Total Salary: ₱%.2f]",
                getEmpID(),
                getEmpName(),
                getBirthDate(),
                getDateHired(),
                totalPiecesFinished,
                ratePerPiece,
                computeSalary()
        );
    }

    // equals
    @Override
    public boolean equals(Object obj) {

        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof PieceWorkerEmployee)) {
            return false;
        }

        PieceWorkerEmployee other =
                (PieceWorkerEmployee) obj;

        return totalPiecesFinished ==
                other.totalPiecesFinished
                && Double.compare(
                ratePerPiece,
                other.ratePerPiece
        ) == 0;
    }

    // hashCode
    @Override
    public int hashCode() {

        return Objects.hash(
                super.hashCode(),
                totalPiecesFinished,
                ratePerPiece
        );
    }

    // clone
    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}