package pl.engineerproject.pw.fifapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Team implements Serializable {


    private static final long serialVersionUID = 8221849130562357797L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer teamId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer overall;

    @Column
    private String logoUrl;

    @OneToMany
    private List<MatchData> matches = new LinkedList<>();

    public Team(String name, Integer overall, String logoUrl, List<MatchData> matches) {
        this.name = name;
        this.overall = overall;
        this.logoUrl = logoUrl;
        this.matches = matches;
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

    public Integer getOverall() {
        return overall;
    }

    public void setOverall(Integer overall) {
        this.overall = overall;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public List<MatchData> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchData> matches) {
        this.matches = matches;
    }
}
