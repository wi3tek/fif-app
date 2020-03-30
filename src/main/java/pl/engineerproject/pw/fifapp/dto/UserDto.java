package pl.engineerproject.pw.fifapp.dto;

import pl.engineerproject.pw.fifapp.model.Role;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class UserDto {

    private Integer id;
    private String username;
    private String email;
    private boolean activeFlag;
    private String registrationReason;
    private LocalDateTime registrationDate;
    private List<String> roles;

    public UserDto(Integer id, String username, String email, boolean activeFlag,
                   String registrationReason, LocalDateTime registrationDate, List<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.activeFlag = activeFlag;
        this.registrationReason = registrationReason;
        this.registrationDate = registrationDate;
        this.roles = roles;
    }

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getRegistrationReason() {
        return registrationReason;
    }

    public void setRegistrationReason(String registrationReason) {
        this.registrationReason = registrationReason;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
