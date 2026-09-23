package version5;

public class Mainv5 {

    public static void main(String[] args) {

        // =====================================================
        // DYNAMIC ROSTER INITIALIZATION
        // =====================================================

        System.out.println(
                "======================================================================"
        );
        System.out.println(
                "          DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)"
        );
        System.out.println(
                "======================================================================"
        );

        EmployeeRoster roster = new EmployeeRoster();


        // =====================================================
        // 1. HOURLY EMPLOYEE
        // =====================================================

        HourlyEmployee alice = new HourlyEmployee(
                101,
                new Name("Alice", "Marie", "Smith"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                45,
                200
        );

        roster.addEmployee(alice);

        System.out.println(
                "Enrolled: " + alice.getEmpName() + " (Hourly)"
        );


        // =====================================================
        // 2. PIECE WORKER EMPLOYEE
        // =====================================================

        PieceWorkerEmployee bob = new PieceWorkerEmployee(
                201,
                new Name("Bob", "Charles", "Jones", "Jr."),
                new MyDate(5, 4, 1998),
                new MyDate(15, 1, 2023),
                250,
                15
        );

        roster.addEmployee(bob);

        System.out.println(
                "Enrolled: " + bob.getEmpName()
                        + " (Piece Worker)"
        );


        // =====================================================
        // 3. COMMISSION EMPLOYEE
        // =====================================================

        CommissionEmployee maria = new CommissionEmployee(
                301,
                new Name("Maria", "L", "Reyes"),
                new MyDate(10, 9, 1999),
                new MyDate(10, 2, 2021),
                100000
        );

        roster.addEmployee(maria);

        System.out.println(
                "Enrolled: " + maria.getEmpName()
                        + " (Commission)"
        );


        // =====================================================
        // 4. BASE PLUS COMMISSION EMPLOYEE
        // =====================================================

        BasePlusCommissionEmployee kevin =
                new BasePlusCommissionEmployee(
                        401,
                        new Name("Kevin", "S", "Tan"),
                        new MyDate(20, 12, 1997),
                        new MyDate(5, 3, 2020),
                        150000,
                        9500
                );

        roster.addEmployee(kevin);

        System.out.println(
                "Enrolled: " + kevin.getEmpName()
                        + " (Base Plus Commission)"
        );


        // =====================================================
        // ROSTER SIZE
        // =====================================================

        System.out.println(
                "Total Roster Size: "
                        + roster.countEmployees()
                        + " employees"
        );


        // =====================================================
        // DYNAMIC POLYMORPHIC PAYROLL
        // =====================================================

        System.out.println(
                "======================================================================"
        );
        System.out.println(
                "          PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)"
        );
        System.out.println(
                "          [No downcasting; dynamic dispatch via Employee.computeSalary()]"
        );
        System.out.println(
                "======================================================================"
        );

        roster.displayPayroll(9);


        // =====================================================
        // COLLECTION COUNTS
        // =====================================================

        System.out.println();
        System.out.println(
                "Employee Counts:"
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


        // =====================================================
        // COLLECTION REMOVAL TEST
        // =====================================================

        System.out.println(
                "======================================================================"
        );
        System.out.println(
                "                    COLLECTION REMOVAL TEST"
        );
        System.out.println(
                "======================================================================"
        );

        System.out.print(
                "Removing Employee ID 201... "
        );

        Employee removed = roster.removeEmployee(201);

        if (removed != null) {
            System.out.println("Successfully removed.");
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println(
                "Updated Roster Size: "
                        + roster.countEmployees()
        );


        // =====================================================
        // CURRENT ACTIVE EMPLOYEES
        // =====================================================

        System.out.println(
                "Current Active Employees:"
        );

        roster.displayAllEmployees();
    }
}