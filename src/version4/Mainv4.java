package version4;

public class Mainv4 {

    public static void main(String[] args) {

        // =========================================================
        // 1. CREATE EMPLOYEE ROSTER WITH CAPACITY OF 6
        // =========================================================

        EmployeeRoster roster = new EmployeeRoster(6);

        System.out.println("========================================");
        System.out.println("       EMPLOYEE ROSTER - VERSION 4");
        System.out.println("========================================");


        // =========================================================
        // 2. CREATE EMPLOYEES
        // =========================================================

        // Hourly Employee #101
        Name name1 = new Name(
                "Alice",
                "Marie",
                "Smith"
        );

        MyDate birth1 = new MyDate(
                18,
                9,
                2000
        );

        MyDate hired1 = new MyDate(
                1,
                6,
                2022
        );

        HourlyEmployee hourly1 = new HourlyEmployee(
                101,
                name1,
                birth1,
                hired1,
                45,
                200
        );


        // Piece Worker Employee #201
        Name name2 = new Name(
                "Bob",
                "Charles",
                "Jones",
                "Jr."
        );

        MyDate birth2 = new MyDate(
                5,
                4,
                1998
        );

        MyDate hired2 = new MyDate(
                15,
                1,
                2023
        );

        PieceWorkerEmployee piece1 =
                new PieceWorkerEmployee(
                        201,
                        name2,
                        birth2,
                        hired2,
                        250,
                        15
                );


        // Commission Employee #301
        Name name3 = new Name(
                "Maria",
                "L",
                "Reyes"
        );

        MyDate birth3 = new MyDate(
                10,
                9,
                1999
        );

        MyDate hired3 = new MyDate(
                10,
                2,
                2021
        );

        CommissionEmployee commission1 =
                new CommissionEmployee(
                        301,
                        name3,
                        birth3,
                        hired3,
                        150000
                );


        // Base Plus Commission Employee #401
        Name name4 = new Name(
                "Kevin",
                "S",
                "Tan"
        );

        MyDate birth4 = new MyDate(
                20,
                12,
                1997
        );

        MyDate hired4 = new MyDate(
                5,
                3,
                2020
        );

        BasePlusCommissionEmployee bpce1 =
                new BasePlusCommissionEmployee(
                        401,
                        name4,
                        birth4,
                        hired4,
                        150000,
                        9500
                );


        // Hourly Employee #102
        Name name5 = new Name(
                "David",
                "A",
                "White"
        );

        MyDate birth5 = new MyDate(
                12,
                7,
                2001
        );

        MyDate hired5 = new MyDate(
                8,
                8,
                2024
        );

        HourlyEmployee hourly2 =
                new HourlyEmployee(
                        102,
                        name5,
                        birth5,
                        hired5,
                        40,
                        200
                );


        // =========================================================
        // 3. ADD EMPLOYEES TO ROSTER
        // =========================================================

        System.out.println("\nAdding employees...");

        System.out.println(
                "Add Alice: "
                        + roster.addEmployee(hourly1)
        );

        System.out.println(
                "Add Bob: "
                        + roster.addEmployee(piece1)
        );

        System.out.println(
                "Add Maria: "
                        + roster.addEmployee(commission1)
        );

        System.out.println(
                "Add Kevin: "
                        + roster.addEmployee(bpce1)
        );

        System.out.println(
                "Add David: "
                        + roster.addEmployee(hourly2)
        );


        // =========================================================
        // 4. TEST CAPACITY
        // =========================================================

        System.out.println("\nTesting roster capacity...");

        Name tempName = new Name(
                "Temporary",
                "Employee"
        );

        MyDate tempBirth = new MyDate(
                1,
                1,
                2000
        );

        MyDate tempHired = new MyDate(
                1,
                1,
                2025
        );

        HourlyEmployee tempEmployee =
                new HourlyEmployee(
                        999,
                        tempName,
                        tempBirth,
                        tempHired,
                        40,
                        100
                );

        System.out.println(
                "Add temporary employee: "
                        + roster.addEmployee(tempEmployee)
        );

        System.out.println(
                "Roster count: "
                        + roster.getCount()
                        + "/"
                        + roster.getMax()
        );


        // Try to add employee beyond capacity
        HourlyEmployee beyondCapacity =
                new HourlyEmployee(
                        1000,
                        new Name("Beyond", "Capacity"),
                        new MyDate(1, 1, 2000),
                        new MyDate(1, 1, 2025),
                        40,
                        100
                );

        System.out.println(
                "Add beyond capacity: "
                        + roster.addEmployee(beyondCapacity)
        );


        // Remove temporary employee so the roster
        // returns to the five required employees.
        roster.removeEmployee(999);


        // =========================================================
        // 5. SEARCH EMPLOYEE
        // =========================================================

        System.out.println("\nSearching for Employee ID 301...");

        Employee found = roster.searchEmployee(301);

        if (found != null) {
            System.out.println(
                    "Found: "
                            + found.getEmpName().displayName()
            );
        } else {
            System.out.println("Employee not found.");
        }


        // =========================================================
        // 6. DISPLAY COUNTS
        // =========================================================

        System.out.println("\n========================================");
        System.out.println("          EMPLOYEE COUNTS");
        System.out.println("========================================");

        System.out.println(
                "Total Employees: "
                        + roster.getCount()
        );

        System.out.println(
                "Hourly Employees: "
                        + roster.countHE()
        );

        System.out.println(
                "Piece Worker Employees: "
                        + roster.countPWE()
        );

        System.out.println(
                "Commission Employees: "
                        + roster.countCE()
        );

        System.out.println(
                "Base Plus Commission Employees: "
                        + roster.countBPCE()
        );


        // =========================================================
        // 7. DISPLAY CATEGORICAL EMPLOYEES
        // =========================================================

        roster.displayHE();

        roster.displayPWE();

        roster.displayCE();

        roster.displayBPCE();


        // =========================================================
        // 8. DISPLAY ALL EMPLOYEES
        // =========================================================

        roster.displayAllEmployees();


        // =========================================================
        // 9. DISPLAY PAYROLL
        // Current month = September (9)
        // =========================================================

        System.out.println("\n========================================");
        System.out.println("       PAYROLL FOR SEPTEMBER");
        System.out.println("========================================");

        roster.displayPayroll(9);


        // =========================================================
        // 10. REMOVE MIDDLE EMPLOYEE
        // Remove Employee ID 201 - Bob
        // =========================================================

        System.out.println("\n========================================");
        System.out.println("       REMOVING EMPLOYEE 201");
        System.out.println("========================================");

        Employee removed = roster.removeEmployee(201);

        if (removed != null) {
            System.out.println(
                    "Removed: "
                            + removed.getEmpName().displayName()
            );
        } else {
            System.out.println("Employee not found.");
        }


        // =========================================================
        // 11. DISPLAY AFTER REMOVAL
        // Verify array compaction
        // =========================================================

        System.out.println("\nAfter removal:");

        roster.displayAllEmployees();
    }
}
