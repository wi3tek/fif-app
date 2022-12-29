package pl.engineerproject.pw.fifapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 5626055063095835491L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable=false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String registrationReason;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false)
    private boolean activeFlag;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    private List<Role> roles = new ArrayList<Role>();

    public User(String username, String password, String email, String registrationReason,
                LocalDateTime registrationDate, boolean activeFlag) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.registrationReason = registrationReason;
        this.registrationDate = registrationDate;
        this.activeFlag = activeFlag;
    }
}
