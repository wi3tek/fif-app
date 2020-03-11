package pl.engineerproject.pw.fifapp.converter;

import org.modelmapper.ModelMapper;
import pl.engineerproject.pw.fifapp.dto.UserDto;
import pl.engineerproject.pw.fifapp.model.User;

import java.util.stream.Collectors;

public class UserConverter   {

    public static User dtoToEntity(UserDto userDto) {
        User user = new User(userDto.getUsername(), userDto.getPassword());
        user.setId(userDto.getId());
        return user;
    }

    public static UserDto entityToDto(User user) {

        return new UserDto(user.getId(),user.getUsername(),user.getPassword());
    }

}
