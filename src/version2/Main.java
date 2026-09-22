package version2;

public class Main {

    public static void main(String[] args) {

        // ==========================================
        // NAME & DATE OUTPUT VERIFICATION
        // ==========================================

        System.out.println("--- Name & Date Output Verification ---");

        Name sampleName = new Name(
                "Alice",
                "Marie",
                "Smith"
        );

        MyDate sampleDate = new MyDate(
                18,
                9,
                2026
        );

        sampleName.displayName();
        sampleDate.displayDate();

        System.out.println();


        // ==========================================
        // HOURLY EMPLOYEE
        // ==========================================

        System.out.println("--- Hourly Employee Payroll Test ---");

        // Partial constructor + setters
        HourlyEmployee hourly1 =
                new HourlyEmployee(
                        101,
                        new Name("Alice", "Smith")
                );

        hourly1.setBirthDate(
                new MyDate(18, 9, 2000)
        );

        hourly1.setDateHired(
                new MyDate(1, 6, 2022)
        );

        hourly1.setTotalHoursWorked(45);
        hourly1.setRatePerHour(200);

        // Full constructor
        HourlyEmployee hourly2 =
                new HourlyEmployee(
                        102,
                        new Name(
                                "Bob",
                                "Charles",
                                "Jones",
                                "Jr."
                        ),
                        new MyDate(10, 12, 1999),
                        new MyDate(15, 3, 2023),
                        38,
                        250
                );

        hourly1.displayHourlyEmployee();
        System.out.println(hourly1);

        System.out.printf(
                "Regular Month (Oct) Salary: ₱%.2f%n",
                hourly1.computeSalary(10)
        );

        System.out.printf(
                "Birth Month (Sep) Salary (+₱5,000.00): ₱%.2f%n",
                hourly1.computeSalary(9)
        );

        System.out.println();

        hourly2.displayHourlyEmployee();
        System.out.println(hourly2);

        System.out.printf(
                "Regular Month (Nov) Salary: ₱%.2f%n",
                hourly2.computeSalary(11)
        );

        System.out.printf(
                "Birth Month (Dec) Salary (+₱5,000.00): ₱%.2f%n",
                hourly2.computeSalary(12)
        );

        System.out.println();


        // ==========================================
        // PIECE WORKER EMPLOYEE
        // ==========================================

        System.out.println("--- Piece Worker Employee Payroll Test ---");

        // Partial constructor + setters
        PieceWorkerEmployee piece1 =
                new PieceWorkerEmployee(
                        201,
                        new Name("Charlie", "Brown")
                );

        piece1.setBirthDate(
                new MyDate(5, 9, 2001)
        );

        piece1.setDateHired(
                new MyDate(10, 1, 2024)
        );

        piece1.setTotalPiecesFinished(250);
        piece1.setRatePerPiece(20);

        // Full constructor
        PieceWorkerEmployee piece2 =
                new PieceWorkerEmployee(
                        202,
                        new Name(
                                "David",
                                "Lee",
                                "Garcia",
                                "III"
                        ),
                        new MyDate(20, 12, 2000),
                        new MyDate(5, 5, 2023),
                        350,
                        15
                );

        piece1.displayPieceWorkerEmployee();
        System.out.println(piece1);

        System.out.printf(
                "Regular Month (Oct) Salary: ₱%.2f%n",
                piece1.computeSalary(10)
        );

        System.out.printf(
                "Birth Month (Sep) Salary (+₱5,000.00): ₱%.2f%n",
                piece1.computeSalary(9)
        );

        System.out.println();

        piece2.displayPieceWorkerEmployee();
        System.out.println(piece2);

        System.out.printf(
                "Regular Month (Nov) Salary: ₱%.2f%n",
                piece2.computeSalary(11)
        );

        System.out.printf(
                "Birth Month (Dec) Salary (+₱5,000.00): ₱%.2f%n",
                piece2.computeSalary(12)
        );

        System.out.println();


        // ==========================================
        // COMMISSION EMPLOYEE
        // ==========================================

        System.out.println("--- Commission Employee Payroll Test ---");

        // Partial constructor + setters
        CommissionEmployee commission1 =
                new CommissionEmployee(
                        301,
                        new Name("Edward", "Miller")
                );

        commission1.setBirthDate(
                new MyDate(12, 9, 2002)
        );

        commission1.setDateHired(
                new MyDate(1, 2, 2024)
        );

        commission1.setTotalSale(80000);

        // Full constructor
        CommissionEmployee commission2 =
                new CommissionEmployee(
                        302,
                        new Name(
                                "Frank",
                                "William",
                                "Wilson",
                                "Jr."
                        ),
                        new MyDate(8, 12, 1998),
                        new MyDate(15, 7, 2022),
                        150000
                );

        commission1.displayCommissionEmployee();
        System.out.println(commission1);

        System.out.printf(
                "Regular Month (Oct) Salary: ₱%.2f%n",
                commission1.computeSalary(10)
        );

        System.out.printf(
                "Birth Month (Sep) Salary (+₱5,000.00): ₱%.2f%n",
                commission1.computeSalary(9)
        );

        System.out.println();

        commission2.displayCommissionEmployee();
        System.out.println(commission2);

        System.out.printf(
                "Regular Month (Nov) Salary: ₱%.2f%n",
                commission2.computeSalary(11)
        );

        System.out.printf(
                "Birth Month (Dec) Salary (+₱5,000.00): ₱%.2f%n",
                commission2.computeSalary(12)
        );

        System.out.println();


        // ==========================================
        // BASE PLUS COMMISSION EMPLOYEE
        // ==========================================

        System.out.println("--- Base Plus Commission Employee Payroll Test ---");

        // Partial constructor + setters
        BasePlusCommissionEmployee base1 =
                new BasePlusCommissionEmployee(
                        401,
                        new Name("George", "Taylor")
                );

        base1.setBirthDate(
                new MyDate(25, 9, 2000)
        );

        base1.setDateHired(
                new MyDate(1, 3, 2023)
        );

        base1.setTotalSale(120000);
        base1.setBaseSalary(10000);

        // Full constructor
        BasePlusCommissionEmployee base2 =
                new BasePlusCommissionEmployee(
                        402,
                        new Name(
                                "Henry",
                                "James",
                                "Anderson",
                                "III"
                        ),
                        new MyDate(30, 12, 1997),
                        new MyDate(20, 8, 2021),
                        600000,
                        15000
                );

        base1.displayBasePlusCommissionEmployee();
        System.out.println(base1);

        System.out.printf(
                "Regular Month (Oct) Salary: ₱%.2f%n",
                base1.computeSalary(10)
        );

        System.out.printf(
                "Birth Month (Sep) Salary (+₱5,000.00): ₱%.2f%n",
                base1.computeSalary(9)
        );

        System.out.println();

        base2.displayBasePlusCommissionEmployee();
        System.out.println(base2);

        System.out.printf(
                "Regular Month (Nov) Salary: ₱%.2f%n",
                base2.computeSalary(11)
        );

        System.out.printf(
                "Birth Month (Dec) Salary (+₱5,000.00): ₱%.2f%n",
                base2.computeSalary(12)
        );
    }
}