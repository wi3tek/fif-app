package pl.engineerproject.pw.fifapp.service;

import pl.engineerproject.pw.fifapp.dto.RegistrationFormDto;
import pl.engineerproject.pw.fifapp.dto.UserDto;
import pl.engineerproject.pw.fifapp.model.User;

import java.util.List;

public interface UserService {

    void createUser(RegistrationFormDto registrationForm);
    void saveUser(User user);
    void updateUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserById(Integer userId);
    void setUserAccess(Integer userId, boolean access);
    UserDto getUserByUsername(String username);
}
