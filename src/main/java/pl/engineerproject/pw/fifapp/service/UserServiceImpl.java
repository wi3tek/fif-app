package pl.engineerproject.pw.fifapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.engineerproject.pw.fifapp.converter.UserConverter;
import pl.engineerproject.pw.fifapp.dto.RegistrationFormDto;
import pl.engineerproject.pw.fifapp.dto.UserDto;
import pl.engineerproject.pw.fifapp.model.Role;
import pl.engineerproject.pw.fifapp.model.User;
import pl.engineerproject.pw.fifapp.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

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

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    public void updateUser(UserDto userDto) {
        userRepository.save(UserConverter.dtoToEntity(userDto));
    }

    @Override
    public UserDto getUserById(Integer userId) {
        return UserConverter.entityToDto(userRepository.getOne(userId));
    }

    @Override
    public UserDto getUserByUsername(String username) {
        return UserConverter.entityToDto(userRepository.findByUsername(username));
    }

    public void setUserAccess(Integer userId, boolean access) {
        User user = userRepository.getOne(userId);
        user.setActiveFlag(access);

        userRepository.save(user);
    }
}
