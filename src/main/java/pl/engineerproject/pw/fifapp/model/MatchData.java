package pl.engineerproject.pw.fifapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class MatchData implements Serializable {
    private static final long serialVersionUID = 6477919665194573452L;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer matchId;

    @Column
    private Date matchDate;

    @OneToOne
    private List<Player> homeFirstPlayer = new LinkedList<>();

    @OneToOne
    private List<Player> homeSecondPlayer = new LinkedList<>();

    @OneToOne
    private List<Player> awayFirstPlayer = new LinkedList<>();

    @OneToOne
    private List<Player> awaySecondPlayer = new LinkedList<>();

    @Column
    private Integer homeGoals;

    @Column
    private Integer awayGoals;

    @OneToOne
    private List<Team> homeTeam = new LinkedList<>();

    @OneToOne
    private List<Team> awayTeam = new LinkedList<>();

    @Column
    private String comment;

    @Column
    private Date updateDate;

    @Column
    private Character matchType;

    @ManyToOne
    private List<Round> round = new LinkedList<>();


    public MatchData(Date matchDate, List<Player> homeFirstPlayer, List<Player> homeSecondPlayer, List<Player> awayFirstPlayer, List<Player> awaySecondPlayer, Integer homeGoals, Integer awayGoals, List<Team> homeTeam, List<Team> awayTeam, String comment, Date updateDate, Character matchType, List<Round> round) {

        this.matchDate=matchDate;
        this.homeFirstPlayer=homeFirstPlayer;
        this.homeSecondPlayer=homeSecondPlayer;
        this.awayFirstPlayer=awayFirstPlayer;
        this.awaySecondPlayer=awaySecondPlayer;
        this.homeGoals = homeGoals;
        this.awayGoals=awayGoals;
        this.homeTeam=homeTeam;
        this.awayTeam=awayTeam;
        this.comment=comment;
        this.updateDate=updateDate;
        this.matchType=matchType;
        this.round=round;

    }

    public MatchData() {

    }


    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public List<Player> getHomeFirstPlayer() {
        return homeFirstPlayer;
    }

    public void setHomeFirstPlayer(List<Player> homeFirstPlayer) {
        this.homeFirstPlayer = homeFirstPlayer;
    }

    public List<Player> getHomeSecondPlayer() {
        return homeSecondPlayer;
    }

    public void setHomeSecondPlayer(List<Player> homeSecondPlayer) {
        this.homeSecondPlayer = homeSecondPlayer;
    }

    public List<Player> getAwayFirstPlayer() {
        return awayFirstPlayer;
    }

    public void setAwayFirstPlayer(List<Player> awayFirstPlayer) {
        this.awayFirstPlayer = awayFirstPlayer;
    }

    public List<Player> getAwaySecondPlayer() {
        return awaySecondPlayer;
    }

    public void setAwaySecondPlayer(List<Player> awaySecondPlayer) {
        this.awaySecondPlayer = awaySecondPlayer;
    }

    public Integer getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(Integer homeGoals) {
        this.homeGoals = homeGoals;
    }

    public Integer getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(Integer awayGoals) {
        this.awayGoals = awayGoals;
    }

    public List<Team> getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(List<Team> homeTeam) {
        this.homeTeam = homeTeam;
    }

    public List<Team> getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(List<Team> awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Character getMatchType() {
        return matchType;
    }

    public void setMatchType(Character matchType) {
        this.matchType = matchType;
    }

    public List<Round> getRound() {
        return round;
    }

    public void setRound(List<Round> round) {
        this.round = round;
    }
}
