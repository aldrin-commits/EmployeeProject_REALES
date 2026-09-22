package version3;

import java.util.Objects;

public class Name implements Cloneable {

    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    // Default constructor
    public Name() {
        firstName = "N/A";
        middleName = "N/A";
        lastName = "N/A";
        suffix = "";
    }

    // First and last name constructor
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
        this.suffix = "";
    }

    // First, middle, and last name constructor
    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = "";
    }

    // Full constructor
    public Name(String firstName, String middleName,
                String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    // Setters
    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.trim().isEmpty()) {
            this.firstName = firstName;
        }
    }

    public void setMiddleName(String middleName) {
        if (middleName != null) {
            this.middleName = middleName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            this.lastName = lastName;
        }
    }

    public void setSuffix(String suffix) {
        if (suffix != null) {
            this.suffix = suffix;
        }
    }

    // Display
    public void displayName() {
        System.out.println("Name: " + this);
    }

    // toString
    @Override
    public String toString() {

        String result = lastName + ", " + firstName;

        if (middleName != null && !middleName.trim().isEmpty()) {
            result += " " + middleName.charAt(0) + ".";
        }

        if (suffix != null && !suffix.trim().isEmpty()) {
            result += " " + suffix;
        }

        return result;
    }

    // equals
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Name)) {
            return false;
        }

        Name other = (Name) obj;

        return Objects.equals(firstName, other.firstName)
                && Objects.equals(middleName, other.middleName)
                && Objects.equals(lastName, other.lastName)
                && Objects.equals(suffix, other.suffix);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, suffix);
    }

    // clone
    @Override
    public Name clone() {

        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}