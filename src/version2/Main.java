package version2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Name name = new Name("Juan", "Dela", "Cruz");
        MyDate dates = new MyDate(
                LocalDate.of(2025, 6, 15),
                LocalDate.of(2005, 9, 20)
        );

        HourlyEmployee employee = new HourlyEmployee(
                1001,
                name,
                dates,
                40,
                100
        );

        employee.displayHourlyEmployee();
        System.out.println(employee);
    }
}
