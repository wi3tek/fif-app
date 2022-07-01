package pl.engineerproject.pw.fifapp.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class League implements Serializable {

    private static final long serialVersionUID = 8871472796696693981L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer leagueId;
    @Column(unique = true)
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String location;

    @ManyToOne
    private User owner;

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public League(String name, String description, String startDate, String endDate, String location, User owner) {
        this.name=name;
        this.description=description;
        this.startDate=startDate;
        this.endDate=endDate;
        this.location=location;
        this.owner = owner;
    }
}
