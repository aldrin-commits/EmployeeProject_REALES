package version1;

public class PieceWorkerEmployee {

    private int empID;
    private String empName;
    private int totalPiecesFinished;
    private double ratePerPiece;

    // Default constructor
    public PieceWorkerEmployee() {
        empID = 0;
        empName = "N/A";
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }

    // Partial constructor
    public PieceWorkerEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    // Full constructor
    public PieceWorkerEmployee(int empID, String empName,
                               int totalPiecesFinished,
                               double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    // Getters
    public int getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    // Setters
    public void setEmpID(int empID) {
        if (empID >= 0) {
            this.empID = empID;
        }
    }

    public void setEmpName(String empName) {
        if (empName != null && !empName.trim().isEmpty()) {
            this.empName = empName;
        }
    }

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

    // Computes salary
    public double computeSalary() {

        double basePay =
                totalPiecesFinished * ratePerPiece;

        int completeHundreds =
                totalPiecesFinished / 100;

        double bonusPay =
                completeHundreds * (10 * ratePerPiece);

        return basePay + bonusPay;
    }

    // Displays employee information
    public void displayPieceWorkerEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | Pieces Finished: %d "
                        + "| Rate/Piece: ₱%.2f%n",
                empID,
                empName,
                totalPiecesFinished,
                ratePerPiece
        );
    }

    // Returns employee information
    @Override
    public String toString() {

        return String.format(
                "PieceWorkerEmployee [ID: %d, Name: %s, "
                        + "Pieces: %d, Rate: ₱%.2f, Total Salary: ₱%.2f]",
                empID,
                empName,
                totalPiecesFinished,
                ratePerPiece,
                computeSalary()
        );
    }
}