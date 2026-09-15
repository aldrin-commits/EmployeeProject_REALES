package version2;

public class Main {
    public static void main(String[] args) {

        Name name = new Name("Juan", "Dela", "Cruz");
        MyDate dateHired = new MyDate(15, 6, 2025);
        MyDate birthDate = new MyDate(20, 9, 2005);

        HourlyEmployee employee = new HourlyEmployee(
                1001,
                name,
                dateHired,
                birthDate,
                40,
                100
        );

        employee.displayHourlyEmployee();
        System.out.println(employee);
    }
}
