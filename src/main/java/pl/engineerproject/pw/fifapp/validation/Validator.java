package pl.engineerproject.pw.fifapp.validation;

import javax.validation.constraints.Email;

public class Validator {

    public static boolean isEmailConfirmed(@Email String email, @Email String confirmEmail) {
        return email.equals(confirmEmail);
    }

    public static boolean isPasswordConfirmed(String password, String confirmPassford) {
        return password.equals(confirmPassford);
    }
}
