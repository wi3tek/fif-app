package pl.engineerproject.pw.fifapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 5626055063095835491L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable=false)
    private String password;

    private int active;

    private String roles ="";

    private String permissions ="";

    @OneToOne
    private List<Player> player = new LinkedList<>();



    public User(String username, String password, String roles, String permissions, List<Player> player) {
        this.username =username;
        this.password=password;
        this.roles=roles;
        this.permissions=permissions;
        this.active=1;
        this.player=player;


    }


    protected User() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public List<String> getRoleList() {

        if(this.roles.length() >0) {
            return Arrays.asList(this.roles.split(";"));
        }
        return new ArrayList<>();
    }


    public List<String> getPermissionList() {

        if(this.permissions.length() >0) {
            return Arrays.asList(this.permissions.split(";"));
        }
        return new ArrayList<>();
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }
}
