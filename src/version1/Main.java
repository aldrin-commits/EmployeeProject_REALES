package version1;

public class Main {

    public static void main(String[] args) {

        // ==========================================
        // HOURLY EMPLOYEE TEST
        // ==========================================

        System.out.println("--- Hourly Employee Test ---");

        // Partial constructor + setters
        HourlyEmployee hourly1 =
                new HourlyEmployee(101, "Alice Smith");

        hourly1.setTotalHoursWorked(45);
        hourly1.setRatePerHour(200);

        // Full constructor
        HourlyEmployee hourly2 =
                new HourlyEmployee(
                        102,
                        "John Doe",
                        38,
                        250
                );

        System.out.println("[displayHourlyEmployee()]");
        hourly1.displayHourlyEmployee();
        hourly2.displayHourlyEmployee();

        System.out.println("[toString()]");
        System.out.println(hourly1);
        System.out.println(hourly2);

        System.out.println();


        // ==========================================
        // PIECE WORKER EMPLOYEE TEST
        // ==========================================

        System.out.println("--- Piece Worker Employee Test ---");

        // Partial constructor + setters
        PieceWorkerEmployee piece1 =
                new PieceWorkerEmployee(201, "Bob Jones");

        piece1.setTotalPiecesFinished(250);
        piece1.setRatePerPiece(15);

        // Full constructor
        PieceWorkerEmployee piece2 =
                new PieceWorkerEmployee(
                        202,
                        "Charlie Brown",
                        350,
                        20
                );

        System.out.println("[displayPieceWorkerEmployee()]");
        piece1.displayPieceWorkerEmployee();
        piece2.displayPieceWorkerEmployee();

        System.out.println("[toString()]");
        System.out.println(piece1);
        System.out.println(piece2);

        System.out.println();


        // ==========================================
        // COMMISSION EMPLOYEE TEST
        // ==========================================

        System.out.println("--- Commission Employee Test ---");

        // Partial constructor + setters
        CommissionEmployee commission1 =
                new CommissionEmployee(
                        301,
                        "David Wilson"
                );

        commission1.setTotalSale(80000);

        // Full constructor
        CommissionEmployee commission2 =
                new CommissionEmployee(
                        302,
                        "Edward Garcia",
                        150000
                );

        System.out.println("[displayCommissionEmployee()]");
        commission1.displayCommissionEmployee();
        commission2.displayCommissionEmployee();

        System.out.println("[toString()]");
        System.out.println(commission1);
        System.out.println(commission2);

        System.out.println();


        // ==========================================
        // BASE PLUS COMMISSION EMPLOYEE TEST
        // ==========================================

        System.out.println(
                "--- Base Plus Commission Employee Test ---"
        );

        // Partial constructor + setters
        BasePlusCommissionEmployee base1 =
                new BasePlusCommissionEmployee(
                        401,
                        "Frank Miller"
                );

        base1.setTotalSale(120000);
        base1.setBaseSalary(10000);

        // Full constructor
        BasePlusCommissionEmployee base2 =
                new BasePlusCommissionEmployee(
                        402,
                        "George Taylor",
                        600000,
                        15000
                );

        System.out.println(
                "[displayBasePlusCommissionEmployee()]"
        );

        base1.displayBasePlusCommissionEmployee();
        base2.displayBasePlusCommissionEmployee();

        System.out.println("[toString()]");
        System.out.println(base1);
        System.out.println(base2);
    }
}