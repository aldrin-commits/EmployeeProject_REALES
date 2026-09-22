package version3;

public class Main {

    public static void main(String[] args) {

        // ==================================================
        // POLYMORPHIC PAYROLL REPORT
        // ==================================================

        int targetMonth = 9;

        System.out.println(
                "=========================================================="
        );

        System.out.println(
                "POLYMORPHIC PAYROLL REPORT (Target Month: Sep)"
        );

        System.out.println(
                "=========================================================="
        );

        // Hourly Employee
        HourlyEmployee hourlyEmployee =
                new HourlyEmployee(
                        101,
                        new Name(
                                "Alice",
                                "Marie",
                                "Smith"
                        ),
                        new MyDate(
                                18,
                                9,
                                2000
                        ),
                        new MyDate(
                                1,
                                6,
                                2022
                        ),
                        45,
                        200
                );

        // Piece Worker Employee
        PieceWorkerEmployee pieceWorkerEmployee =
                new PieceWorkerEmployee(
                        201,
                        new Name(
                                "Bob",
                                "Charles",
                                "Jones",
                                "Jr."
                        ),
                        new MyDate(
                                5,
                                4,
                                1998
                        ),
                        new MyDate(
                                15,
                                1,
                                2023
                        ),
                        250,
                        15
                );

        // Commission Employee
        CommissionEmployee commissionEmployee =
                new CommissionEmployee(
                        301,
                        new Name(
                                "Charlie",
                                "David",
                                "Brown"
                        ),
                        new MyDate(
                                10,
                                9,
                                1999
                        ),
                        new MyDate(
                                20,
                                2,
                                2022
                        ),
                        80000
                );

        // Base Plus Commission Employee
        BasePlusCommissionEmployee basePlusEmployee =
                new BasePlusCommissionEmployee(
                        401,
                        new Name(
                                "David",
                                "Edward",
                                "Wilson"
                        ),
                        new MyDate(
                                15,
                                12,
                                1997
                        ),
                        new MyDate(
                                10,
                                5,
                                2021
                        ),
                        150000,
                        10000
                );


        // ==================================================
        // POLYMORPHIC COLLECTION
        // ==================================================

        Employee[] employees = {
                hourlyEmployee,
                pieceWorkerEmployee,
                commissionEmployee,
                basePlusEmployee
        };

        int counter = 1;

        for (Employee employee : employees) {

            System.out.println(
                    counter + ". " + employee
            );

            double basePay =
                    employee.computeSalary();

            double totalPayout =
                    employee.computeSalary(targetMonth);

            double birthdayBonus =
                    totalPayout - basePay;

            String eligibility;

            if (birthdayBonus > 0) {
                eligibility = "Eligible";
            } else {
                eligibility = "Ineligible";
            }

            System.out.printf(
                    "Base Pay: ₱%.2f | Birthday Bonus: "
                            + "₱%.2f (%s)%n",
                    basePay,
                    birthdayBonus,
                    eligibility
            );

            System.out.printf(
                    "Total Payout: ₱%.2f%n",
                    totalPayout
            );

            System.out.println();

            counter++;
        }


        // ==================================================
        // OBJECT CONTRACT TESTS
        // ==================================================

        System.out.println(
                "=========================================================="
        );

        System.out.println(
                "OBJECT CONTRACT TESTS (equals & hashCode)"
        );

        System.out.println(
                "=========================================================="
        );

        HourlyEmployee emp1 =
                new HourlyEmployee(
                        101,
                        new Name(
                                "Alice",
                                "Marie",
                                "Smith"
                        ),
                        new MyDate(
                                18,
                                9,
                                2000
                        ),
                        new MyDate(
                                1,
                                6,
                                2022
                        ),
                        45,
                        200
                );

        HourlyEmployee emp1Identical =
                new HourlyEmployee(
                        101,
                        new Name(
                                "Alice",
                                "Marie",
                                "Smith"
                        ),
                        new MyDate(
                                18,
                                9,
                                2000
                        ),
                        new MyDate(
                                1,
                                6,
                                2022
                        ),
                        45,
                        200
                );

        System.out.println(
                "emp1 equals emp1Identical: "
                        + emp1.equals(emp1Identical)
        );

        System.out.println(
                "emp1 hashCode: "
                        + emp1.hashCode()
                        + " | emp1Identical hashCode: "
                        + emp1Identical.hashCode()
                        + " (Match: "
                        + (emp1.hashCode()
                        == emp1Identical.hashCode())
                        + ")"
        );

        emp1Identical.setTotalHoursWorked(50);

        System.out.println(
                "emp1 equals modified emp1Identical: "
                        + emp1.equals(emp1Identical)
        );


        // ==================================================
        // DEEP CLONE VERIFICATION
        // ==================================================

        System.out.println();

        System.out.println(
                "=========================================================="
        );

        System.out.println(
                "DEEP CLONE VERIFICATION"
        );

        System.out.println(
                "=========================================================="
        );

        HourlyEmployee empOriginal =
                new HourlyEmployee(
                        501,
                        new Name(
                                "Alice",
                                "Marie",
                                "Smith"
                        ),
                        new MyDate(
                                18,
                                9,
                                2000
                        ),
                        new MyDate(
                                1,
                                6,
                                2022
                        ),
                        45,
                        200
                );

        HourlyEmployee empClone =
                empOriginal.clone();

        System.out.println(
                "Original Name before modification: "
                        + empOriginal.getEmpName()
        );

        empClone.getEmpName().setLastName("Taylor");

        System.out.println(
                "Clone Name changed to: "
                        + empClone.getEmpName()
        );

        System.out.println(
                "Original Name after modification: "
                        + empOriginal.getEmpName()
        );

        System.out.println();

        System.out.println(
                "Original Birth Date before modification: "
                        + empOriginal.getBirthDate()
        );

        empClone.getBirthDate().setMonth(12);

        System.out.println(
                "Clone Birth Date changed to: "
                        + empClone.getBirthDate()
        );

        System.out.println(
                "Original Birth Date after modification: "
                        + empOriginal.getBirthDate()
        );

        System.out.println();

        System.out.println(
                "Deep copy successful if the original "
                        + "remains unchanged."
        );
    }
}