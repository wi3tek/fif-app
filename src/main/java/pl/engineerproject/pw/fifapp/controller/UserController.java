package pl.engineerproject.pw.fifapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.engineerproject.pw.fifapp.converter.MatchConverter;
import pl.engineerproject.pw.fifapp.converter.UserConverter;
import pl.engineerproject.pw.fifapp.dto.MatchDto;
import pl.engineerproject.pw.fifapp.dto.RegistrationFormDto;
import pl.engineerproject.pw.fifapp.dto.UserDto;
import pl.engineerproject.pw.fifapp.model.MatchData;
import pl.engineerproject.pw.fifapp.model.Role;
import pl.engineerproject.pw.fifapp.model.User;
import pl.engineerproject.pw.fifapp.service.UserService;

import javax.xml.ws.Response;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "/usersControls")
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value="/register")
    public ResponseEntity registerUser(@RequestBody RegistrationFormDto registrationFormDto) {

        return userService.createUser(registrationFormDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value ="/activate/{userId}", method = RequestMethod.PUT)
    public void activate(@PathVariable Integer userId) {


        userService.setUserAccess(userId,true);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/deactivate/{userId}",method = RequestMethod.PUT)
    public void deactivate(@PathVariable Integer userId) {
            userService.setUserAccess(userId, false);

    }


    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/getAllUsers")
    public List<UserDto> allUsers() {
         return userService.getAllUsers();
    }


    @RequestMapping("/getUser/{username}")
    public UserDto getUserById(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

}
