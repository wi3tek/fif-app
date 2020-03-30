package pl.engineerproject.pw.fifapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import java.util.List;

@RestController
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value="/register")
    public void registerUser(@RequestBody RegistrationFormDto registrationFormDto) {

        userService.createUser(registrationFormDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.PUT, value="/activate")
    public void activate(@RequestBody UserDto userDto) {
        userDto.setActiveFlag(true);
        userService.updateUser(userDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.PUT, value="/desactivate")
    public void desactivate(@RequestBody UserDto userDto) {
        userDto.setActiveFlag(false);
        userService.updateUser(userDto);
    }


    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/getAllUsers")
    public List<UserDto> allUsers() {
         return userService.getAllUsers();
    }
}
