package pl.engineerproject.pw.fifapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.engineerproject.pw.fifapp.dto.RegistrationFormDto;
import pl.engineerproject.pw.fifapp.dto.UserDto;
import pl.engineerproject.pw.fifapp.model.Role;
import pl.engineerproject.pw.fifapp.model.User;
import pl.engineerproject.pw.fifapp.service.UserService;

import java.security.Principal;

@RestController
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value="/register")
    public void registerUser(@RequestBody RegistrationFormDto registrationFormDto) {

        userService.createUser(registrationFormDto);
    }


    @RequestMapping(method = RequestMethod.PUT, value="/activate")
    public void activateUser(@RequestBody User user) {
        user.setActiveFlag(true);
        userService.saveUser(user);
    }


    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
