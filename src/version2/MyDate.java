package version2;

import java.time.LocalDate;

public class MyDate {

    private LocalDate dateHired;
    private LocalDate birthDate;

    public MyDate() {
        dateHired = LocalDate.now();
        birthDate = LocalDate.now();
    }

    public MyDate(LocalDate dateHired, LocalDate birthDate) {
        this.dateHired = dateHired;
        this.birthDate = birthDate;
    }

    public LocalDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(LocalDate dateHired) {
        this.dateHired = dateHired;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("Date Hired: %s | Birth Date: %s", dateHired, birthDate);
    }
}
