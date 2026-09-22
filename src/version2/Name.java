package version2;

public class Name {

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

    // Displays the formatted name
    public void displayName() {
        System.out.println("Name: " + this);
    }

    // Returns the formatted name
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
}