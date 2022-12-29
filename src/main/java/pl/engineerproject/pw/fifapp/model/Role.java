package pl.engineerproject.pw.fifapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
//@SequenceGenerator(name="user_seq", allocationSize=10000)
public class Role implements Serializable {
    private static final long serialVersionUID = 3936672744653222643L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Integer id;

    @Column(length = 255)
    private String description;

    @Column(name = "role_name", length = 30)
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<User>();

    private boolean activeFlag;


}
