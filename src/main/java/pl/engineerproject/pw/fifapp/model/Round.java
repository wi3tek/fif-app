package pl.engineerproject.pw.fifapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Round implements Serializable {
    private static final long serialVersionUID = 6834844252091608740L;
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roundId;

    @Column
    private Date roundDate;

    @Column
    private Integer whichLeagueRound;

    @Column
    private String description;

    @OneToMany
    private List<MatchData> matches = new LinkedList<>();

    @ManyToOne
    private List<League> league = new LinkedList<>(); //oneElementList

    @OneToMany
    private List<Team> teams = new LinkedList<>();

    public Round(Date roundDate, Integer whichLeagueRound, String description, List<League> league, List<MatchData> matches, List<Team> teams) {
        this.roundDate=roundDate;
        this.whichLeagueRound=whichLeagueRound;
        this.description=description;
        this.league=league;
        this.matches = matches;
        this.teams=teams;
    }

    public Round() {

    }

    public Integer getRoundId() {
        return roundId;
    }

    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }


    public Date getRoundDate() {
        return roundDate;
    }

    public void setRoundDate(Date roundDate) {
        this.roundDate = roundDate;
    }

    public Integer getWhichLeagueRound() {
        return whichLeagueRound;
    }

    public void setWhichLeagueRound(Integer whichLeagueRound) {
        this.whichLeagueRound = whichLeagueRound;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MatchData> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchData> matches) {
        this.matches = matches;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<League> getLeague() {
        return league;
    }

    public void setLeague(List<League> league) {
        this.league = league;
    }
}

