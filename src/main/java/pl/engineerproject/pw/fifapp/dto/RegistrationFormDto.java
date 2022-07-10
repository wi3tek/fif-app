package pl.engineerproject.pw.fifapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Setter
@Getter
public class RegistrationFormDto {

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @Email
    private String confirmEmail;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String confirmPassword;

    @NotNull
    @NotEmpty
    private String registrationReason;
}
