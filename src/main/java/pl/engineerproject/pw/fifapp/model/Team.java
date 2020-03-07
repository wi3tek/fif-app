package pl.engineerproject.pw.fifapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@SequenceGenerator(name="team_seq", initialValue = 800,allocationSize=1000)
public class Team implements Serializable {


    private static final long serialVersionUID = 8221849130562357797L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="team_seq")
    @Column
    private Integer teamId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer overallRating;

    @Column
    private String logoUrl;

    public Team(String name, Integer overallRating, String logoUrl) {
        this.name = name;
        this.overallRating = overallRating;
        this.logoUrl = logoUrl;
    }

    public Team() {

    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Integer overallRating) {
        this.overallRating = overallRating;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
