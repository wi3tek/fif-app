package pl.engineerproject.pw.fifapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Player implements Serializable {

    private static final long serialVersionUID = 8066347468898311564L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer playerId;

    @Column
    private String name;

    @Column
    private String alias;

    @Column
    private Date dateOfBirth;

    @Column
    private Date joinDate;

    @Column
    private Date lastModificationDate;

    @OneToOne
    private List<User> user = new LinkedList<>();


    public Player(String name, String alias, Date dateOfBirth, Date joinDate, Date lastModificationDate, List<User> user) {
        this.name=name;
        this.alias=alias;
        this.dateOfBirth=dateOfBirth;
        this.joinDate=joinDate;
        this.lastModificationDate=lastModificationDate;
        this.user=user;

    }

    public Player() {

    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}

