package br.maua;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void validateFirstName() {
        if ( this.firstName.isBlank() )
            throw new RuntimeException("First name cannot be null or empty!");
    }

    public void validadeLastName() {
        if ( this.lastName.isBlank() )
            throw new RuntimeException("Last name cannot be null or empty!");
    }

    public void validatePhoneNumber() {
        if ( this.phoneNumber.isBlank() ) {
            throw new RuntimeException("Phone number cannot be null or empty!");
        }

        if ( this.phoneNumber.length() != 10 ) {
            throw new RuntimeException("Phone number should be 10 digits long!");
        }

        if ( !this.phoneNumber.matches("\\d+") ) {
            throw new RuntimeException("Phone number contains only digits!");
        }

        if ( !this.phoneNumber.startsWith("0") ) {
            throw new RuntimeException("Phone number should starts with 0");
        }
    }
}
