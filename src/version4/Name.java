package version4;

import java.util.Objects;

public class Name implements Cloneable {

    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
        this.suffix = "";
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String displayName() {
        String name = firstName;

        if (middleName != null && !middleName.isEmpty()) {
            name += " " + middleName;
        }

        if (lastName != null && !lastName.isEmpty()) {
            name += " " + lastName;
        }

        if (suffix != null && !suffix.isEmpty()) {
            name += " " + suffix;
        }

        return name;
    }

    @Override
    public String toString() {
        String result = lastName + ", " + firstName;

        if (middleName != null && !middleName.isEmpty()) {
            result += " " + middleName.charAt(0) + ".";
        }

        if (suffix != null && !suffix.isEmpty()) {
            result += " " + suffix;
        }

        return result;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, suffix);
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
