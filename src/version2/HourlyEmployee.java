package version2;

public class HourlyEmployee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private float totalHoursWorked;
    private double ratePerHour;

    // Default constructor
    public HourlyEmployee() {
        empID = 0;
        empName = new Name();
        birthDate = new MyDate();
        dateHired = new MyDate();
        totalHoursWorked = 0;
        ratePerHour = 0;
    }

    // Partial constructor
    public HourlyEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        totalHoursWorked = 0;
        ratePerHour = 0;
    }

    // Full constructor
    public HourlyEmployee(int empID, Name empName,
                          MyDate birthDate, MyDate dateHired,
                          float totalHoursWorked,
                          double ratePerHour) {

        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
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

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
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

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        }
    }

    // Regular salary without birthday bonus
    public double computeSalary() {

        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        }

        double regularPay = 40 * ratePerHour;
        double overtimeHours = totalHoursWorked - 40;
        double overtimePay = overtimeHours * ratePerHour * 1.5;

        return regularPay + overtimePay;
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
    public void displayHourlyEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | DOB: %s | Hired: %s "
                        + "| Hours: %.2f | Rate: ₱%.2f/hr%n",
                empID,
                empName,
                birthDate,
                dateHired,
                totalHoursWorked,
                ratePerHour
        );
    }

    // String representation
    @Override
    public String toString() {

        return String.format(
                "HourlyEmployee [ID: %d, Name: %s, DOB: %s, "
                        + "Hired: %s, Hours: %.2f, Rate: ₱%.2f, "
                        + "Total Salary: ₱%.2f]",
                empID,
                empName,
                birthDate,
                dateHired,
                totalHoursWorked,
                ratePerHour,
                computeSalary()
        );
    }
}