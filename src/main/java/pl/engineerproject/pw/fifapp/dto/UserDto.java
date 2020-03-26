package pl.engineerproject.pw.fifapp.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class UserDto {

    private Integer id;
    private String username;
    private String password;
    private String role;
    private String email;
    private Integer activeFlag;
    private String registrationReason;
    private LocalDateTime registrationDate;

    public UserDto(Integer id, String username, String password, String role, String email, Integer activeFlag,
                   String registerationReason, LocalDateTime registrationDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.activeFlag = activeFlag;
        this.registrationReason = registerationReason;
        this.registrationDate = registrationDate;
    }

    public UserDto() {
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getRegistrationReason() {
        return registrationReason;
    }

    public void setRegistrationReason(String registrationReason) {
        this.registrationReason = registrationReason;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
