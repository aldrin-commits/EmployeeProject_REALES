package version2;

public class PieceWorkerEmployee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private int totalPiecesFinished;
    private double ratePerPiece;

    // Default constructor
    public PieceWorkerEmployee() {
        empID = 0;
        empName = new Name();
        birthDate = new MyDate();
        dateHired = new MyDate();
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }

    // Partial constructor
    public PieceWorkerEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }

    // Full constructor
    public PieceWorkerEmployee(int empID, Name empName,
                               MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished,
                               double ratePerPiece) {

        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    // Getters
    public int getEmpID() {
        return empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
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

    public void setEmpName(Name empName) {
        if (empName != null) {
            this.empName = empName;
        }
    }

    public void setBirthDate(MyDate birthDate) {
        if (birthDate != null) {
            this.birthDate = birthDate;
        }
    }

    public void setDateHired(MyDate dateHired) {
        if (dateHired != null) {
            this.dateHired = dateHired;
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

    // Regular salary without birthday bonus
    public double computeSalary() {

        double basePay = totalPiecesFinished * ratePerPiece;

        int completeHundreds = totalPiecesFinished / 100;

        double bonusPay =
                completeHundreds * (10 * ratePerPiece);

        return basePay + bonusPay;
    }

    // Salary with birthday incentive
    public double computeSalary(int currentMonth) {

        double salary = computeSalary();

        if (birthDate.getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    // Display employee information
    public void displayPieceWorkerEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | DOB: %s | Hired: %s "
                        + "| Pieces: %d | Rate/Piece: ₱%.2f%n",
                empID,
                empName,
                birthDate,
                dateHired,
                totalPiecesFinished,
                ratePerPiece
        );
    }

    // String representation
    @Override
    public String toString() {

        return String.format(
                "PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, "
                        + "Hired: %s, Pieces: %d, Rate: ₱%.2f, "
                        + "Total Salary: ₱%.2f]",
                empID,
                empName,
                birthDate,
                dateHired,
                totalPiecesFinished,
                ratePerPiece,
                computeSalary()
        );
    }
}