package pl.engineerproject.pw.fifapp.converter;

import pl.engineerproject.pw.fifapp.dto.UserDto;
import pl.engineerproject.pw.fifapp.model.User;

public class UserConverter   {

    public static User dtoToEntity(UserDto userDto) {
        User user = new User(userDto.getUsername(), userDto.getPassword(),"USER",userDto.getEmail(),1,userDto.getRegistrationReason(),userDto.getRegistrationDate());
        user.setId(userDto.getId());
        return user;
    }

    public static UserDto entityToDto(User user) {
        return new UserDto(user.getId(),user.getUsername(),user.getPassword(),user.getRole(),user.getEmail(),user.getActiveFlag(),user.getRegistrationReason(),user.getRegistrationDate());
    }

}
