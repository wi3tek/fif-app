package pl.engineerproject.pw.fifapp.service;

import pl.engineerproject.pw.fifapp.dto.RegistrationFormDto;
import pl.engineerproject.pw.fifapp.dto.UserDto;
import pl.engineerproject.pw.fifapp.model.User;

public interface UserService {
    User findByUsername(String username);
    void createUser(RegistrationFormDto registrationForm);
    void saveUser(User user);
}
