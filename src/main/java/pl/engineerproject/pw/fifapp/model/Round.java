package pl.engineerproject.pw.fifapp.model;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MatchData> matches = new LinkedList<>();

    @ManyToOne
    private League league;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Team> teams = new LinkedList<>();

    public Round(Date roundDate, Integer whichLeagueRound, String description, League league, List<MatchData> matches, List<Team> teams) {
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

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}

