package pl.engineerproject.pw.fifapp.converter;

import pl.engineerproject.pw.fifapp.dto.RoleDto;
import pl.engineerproject.pw.fifapp.dto.UserDto;
import pl.engineerproject.pw.fifapp.model.Role;
import pl.engineerproject.pw.fifapp.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserConverter   {

    public static User dtoToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setActiveFlag(userDto.isActiveFlag());
        user.setRegistrationReason(userDto.getRegistrationReason());
        user.setEmail(userDto.getEmail());
        user.setRegistrationDate(userDto.getRegistrationDate());

        return user;
    }

    public static UserDto entityToDto(User user) {
        List<String> roleDtos = user.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList());
        boolean isAdmin = false;

        for (String roleDto : roleDtos) {
            if (roleDto.equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            }
        }

        return new UserDto(user.getId(),user.getUsername(),user.getEmail(),user.isActiveFlag(),user.getRegistrationReason(),user.getRegistrationDate(),roleDtos, isAdmin);
    }
}
