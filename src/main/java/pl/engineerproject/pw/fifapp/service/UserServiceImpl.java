package pl.engineerproject.pw.fifapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.engineerproject.pw.fifapp.mapper.UserMapper;
import pl.engineerproject.pw.fifapp.dto.RegistrationFormDto;
import pl.engineerproject.pw.fifapp.dto.UserDto;
import pl.engineerproject.pw.fifapp.model.Role;
import pl.engineerproject.pw.fifapp.model.User;
import pl.engineerproject.pw.fifapp.repository.UserRepository;
import pl.engineerproject.pw.fifapp.validation.Validator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity createUser(RegistrationFormDto registrationFormDto) {

        if(!Validator.isEmailConfirmed(registrationFormDto.getEmail(),registrationFormDto.getConfirmEmail()) || !Validator.isPasswordConfirmed(registrationFormDto.getPassword(),registrationFormDto.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("{\"Register form has errors\": \"User was not created\"}");
        } else {
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
            return ResponseEntity.ok("{\"User created\":\""+user.getUsername()+"\"}");
        }
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map( UserMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public void updateUser(UserDto userDto) {
        userRepository.save( UserMapper.dtoToEntity(userDto));
    }

    @Override
    public UserDto getUserById(Integer userId) {
        return UserMapper.entityToDto(userRepository.getOne(userId));
    }

    @Override
    public UserDto getUserByUsername(String username) {
        return UserMapper.entityToDto(userRepository.findByUsername(username));
    }

    public void setUserAccess(Integer userId, boolean access) {
        User user = userRepository.getOne(userId);
        user.setActiveFlag(access);

        userRepository.save(user);
    }
}
