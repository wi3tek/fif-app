package pl.engineerproject.pw.fifapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.engineerproject.pw.fifapp.converter.UserConverter;
import pl.engineerproject.pw.fifapp.dto.RegistrationFormDto;
import pl.engineerproject.pw.fifapp.dto.UserDto;
import pl.engineerproject.pw.fifapp.model.Role;
import pl.engineerproject.pw.fifapp.model.User;
import pl.engineerproject.pw.fifapp.repository.UserRepository;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public void createUser(RegistrationFormDto registrationFormDto) {
        User user = new User();
        user.setUsername(registrationFormDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationFormDto.getPassword()));
        user.setEmail(registrationFormDto.getEmail());
        user.setRegistrationReason(registrationFormDto.getRegistrationReason());
        user.setRegistrationDate(LocalDateTime.now());
        user.setActiveFlag(false);

        Role userRole = new Role();
        userRole.setRoleName("USER");

        user.getRoles().add(userRole);

        userRepository.save(user);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
