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
    private Player homeFirstPlayer;

    @OneToOne
    private Player homeSecondPlayer;

    @OneToOne
    private Player awayFirstPlayer;

    @OneToOne
    private Player awaySecondPlayer;

    @Column
    private Integer homeGoals;

    @Column
    private Integer awayGoals;

    @OneToOne
    private Team homeTeam;

    @OneToOne
    private Team awayTeam;

    @Column
    private String comment;

    @Column
    private Date updateDate;

    @Column
    private Character matchType;

    @ManyToOne
    private Round round; //eventually one element List

    @ManyToOne
    private League league;


    public MatchData(Date matchDate, Player homeFirstPlayer, Player homeSecondPlayer, Player awayFirstPlayer, Player awaySecondPlayer, Integer homeGoals, Integer awayGoals, Team homeTeam, Team awayTeam, String comment, Date updateDate, Character matchType) {

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

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
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


    public Player getHomeFirstPlayer() {
        return homeFirstPlayer;
    }

    public void setHomeFirstPlayer(Player homeFirstPlayer) {
        this.homeFirstPlayer = homeFirstPlayer;
    }

    public Player getHomeSecondPlayer() {
        return homeSecondPlayer;
    }

    public void setHomeSecondPlayer(Player homeSecondPlayer) {
        this.homeSecondPlayer = homeSecondPlayer;
    }

    public Player getAwayFirstPlayer() {
        return awayFirstPlayer;
    }

    public void setAwayFirstPlayer(Player awayFirstPlayer) {
        this.awayFirstPlayer = awayFirstPlayer;
    }

    public Player getAwaySecondPlayer() {
        return awaySecondPlayer;
    }

    public void setAwaySecondPlayer(Player awaySecondPlayer) {
        this.awaySecondPlayer = awaySecondPlayer;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
