package pl.engineerproject.pw.fifapp.dto;

import pl.engineerproject.pw.fifapp.model.Player;
import pl.engineerproject.pw.fifapp.model.Round;
import pl.engineerproject.pw.fifapp.model.Team;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MatchDto {

    private Integer matchId;
    private Date matchDate;
    private List<PlayerDto> homeFirstPlayer;
    private List<PlayerDto> homeSecondPlayer;
    private List<PlayerDto> awayFirstPlayer;
    private List<PlayerDto> awaySecondPlayer;
    private Integer homeGoals;
    private Integer awayGoals;
    private List<TeamDto> homeTeam;
    private List<TeamDto> awayTeam;
    private String comment;
    private Date updateDate;
    private Character matchType;
    private List<RoundDto> roundDtos;


    public MatchDto(Integer matchId, Date matchDate, List<PlayerDto> homeFirstPlayer, List<PlayerDto> homeSecondPlayer,
                    List<PlayerDto> awayFirstPlayer, List<PlayerDto> awaySecondPlayer, Integer homeGoals, Integer awayGoals,
                    List<TeamDto> homeTeam, List<TeamDto> awayTeam, String comment, Date updateDate, Character matchType, List<RoundDto> roundDtos) {
        this.matchId = matchId;
        this.matchDate = matchDate;
        this.homeFirstPlayer = homeFirstPlayer;
        this.homeSecondPlayer = homeSecondPlayer;
        this.awayFirstPlayer = awayFirstPlayer;
        this.awaySecondPlayer = awaySecondPlayer;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.comment = comment;
        this.updateDate = updateDate;
        this.matchType = matchType;
        this.roundDtos=roundDtos;
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

    public List<PlayerDto> getHomeFirstPlayer() {
        return homeFirstPlayer;
    }

    public void setHomeFirstPlayer(List<PlayerDto> homeFirstPlayer) {
        this.homeFirstPlayer = homeFirstPlayer;
    }

    public List<PlayerDto> getHomeSecondPlayer() {
        return homeSecondPlayer;
    }

    public void setHomeSecondPlayer(List<PlayerDto> homeSecondPlayer) {
        this.homeSecondPlayer = homeSecondPlayer;
    }

    public List<PlayerDto> getAwayFirstPlayer() {
        return awayFirstPlayer;
    }

    public void setAwayFirstPlayer(List<PlayerDto> awayFirstPlayer) {
        this.awayFirstPlayer = awayFirstPlayer;
    }

    public List<PlayerDto> getAwaySecondPlayer() {
        return awaySecondPlayer;
    }

    public void setAwaySecondPlayer(List<PlayerDto> awaySecondPlayer) {
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

    public List<TeamDto> getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(List<TeamDto> homeTeam) {
        this.homeTeam = homeTeam;
    }

    public List<TeamDto> getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(List<TeamDto> awayTeam) {
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

    public List<RoundDto> getRounds() {
        return roundDtos;
    }

    public void setRounds(List<RoundDto> rounds) {
        this.roundDtos = rounds;
    }
}
