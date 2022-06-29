package pl.engineerproject.pw.fifapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.engineerproject.pw.fifapp.dto.RegistrationFormDto;
import pl.engineerproject.pw.fifapp.dto.UserDto;
import pl.engineerproject.pw.fifapp.service.UserService;
import java.util.List;


import java.security.Principal;


@RestController
@RequestMapping(path = "/usersControls")
public class UserController {

    @GetMapping("/getUser")
    public Principal user(Principal user) {
        return user;
    }

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody RegistrationFormDto registrationFormDto) {

        return userService.createUser(registrationFormDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/activate/{userId}")
    public void activate(@PathVariable Integer userId) {


        userService.setUserAccess(userId,true);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/deactivate/{userId}")
    public void deactivate(@PathVariable Integer userId) {
            userService.setUserAccess(userId, false);

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
