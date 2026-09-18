public class Login {
    private String storedUsername;
    private String storedPassword;
    private final String firstName;
    private final String lastName;

    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$";
        return password.matches(regex);
    }

    public boolean checkCellPhoneNumber(String cellNumber) {
        String regex = "^\\+\\d{1,12}$";
        return cellNumber.matches(regex);
    }

    public String registerUser(String username, String password, String cellNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }
        this.storedUsername = username;
        this.storedPassword = password;
        return "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.";
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername != null && enteredUsername.equals(this.storedUsername) &&
               enteredPassword != null && enteredPassword.equals(this.storedPassword);
    }

    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + this.firstName + ", " + this.lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}