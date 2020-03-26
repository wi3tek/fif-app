package pl.engineerproject.pw.fifapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@SequenceGenerator(name="user_seq", allocationSize=10000)
public class User implements Serializable {
    private static final long serialVersionUID = 5626055063095835491L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable=false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer activeFlag;

    @Column(nullable = false)
    private String registrationReason;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    public User(String username, String password, String role, String email,Integer activeFlag, String registrationReason, LocalDateTime registrationDate) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.activeFlag=activeFlag;
        this.registrationReason = registrationReason;
        this.registrationDate = registrationDate;
    }

    public User() {

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
