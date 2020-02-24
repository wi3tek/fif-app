package pl.engineerproject.pw.fifapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class League implements Serializable {

    private static final long serialVersionUID = 8871472796696693981L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer leagueId;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String location;

    @OneToMany
    private List<Round> rounds = new LinkedList<>();

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public League(String name, String description, String startDate, String endDate, String location, List<Round> rounds) {
        this.name=name;
        this.description=description;
        this.startDate=startDate;
        this.endDate=endDate;
        this.location=location;
        this.rounds=rounds;
    }

    public League() {

    }

//    @Override
//    public String toString() {
//        return "League{" + "leagueId='" +leagueId+ '\'' + ", name='" + name + '\'' + ", description='" +description+ '\'' + ", startDate='" + '\'' + ", endDate='" + endDate + '\'' + ",location='" + '\'' + "HEHEHEHEHEHE"+'}';
//    }
}
