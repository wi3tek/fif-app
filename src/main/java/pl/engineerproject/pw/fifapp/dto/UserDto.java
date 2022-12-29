package pl.engineerproject.pw.fifapp.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.engineerproject.pw.fifapp.model.Role;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private Integer id;
    private String username;
    private String email;
    private boolean activeFlag;
    private String registrationReason;
    private LocalDateTime registrationDate;
    private List<String> roles;
    private boolean isAdmin;
}
