package pl.engineerproject.pw.fifapp.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerDto {

    private Integer playerId;
    private String name;
    private String alias;
    private Date dateOfBirth;
    private Date joinDate;
    private Date lastModificationDate;
    private Integer userId;
    private String userName;


    public PlayerDto(Integer playerId, String name, String alias, Date dateOfBirth, Date joinDate,
                     Date lastModificationDate) {
        this.playerId = playerId;
        this.name = name;
        this.alias = alias;
        this.dateOfBirth = dateOfBirth;
        this.joinDate = joinDate;
        this.lastModificationDate = lastModificationDate;
    }

    public PlayerDto() {

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
