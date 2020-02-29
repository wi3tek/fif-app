package pl.engineerproject.pw.fifapp.dto;

import java.util.Date;

public class MatchDto {

    private Integer matchId;
    private Date matchDate;
    private Integer homeFirstPlayerId;
    private String homeFirstPlayerName;

    private Integer homeSecondPlayerId;
    private String homeSecondPlayerName;

    private Integer awayFirstPlayerId;
    private String awayFirstPlayerName;

    private Integer awaySecondPlayerId;
    private String awaySecondPlayerName;

    private Integer homeGoals;
    private Integer awayGoals;

    private Integer homeTeamId;
    private String homeTeamName;

    private Integer awayTeamId;
    private String awayTeamName;

    private String comment;
    private Date updateDate;
    private Character matchType;
    private Integer roundId;
    private Integer leagueId;

    public MatchDto(Integer matchId, Date matchDate,Integer homeGoals, Integer awayGoals,String comment, Date updateDate, Character matchType) {
        this.matchId = matchId;
        this.matchDate = matchDate;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.comment = comment;
        this.updateDate = updateDate;
        this.matchType = matchType;
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

    public Integer getHomeFirstPlayerId() {
        return homeFirstPlayerId;
    }

    public void setHomeFirstPlayerId(Integer homeFirstPlayerId) {
        this.homeFirstPlayerId = homeFirstPlayerId;
    }

    public String getHomeFirstPlayerName() {
        return homeFirstPlayerName;
    }

    public void setHomeFirstPlayerName(String homeFirstPlayerName) {
        this.homeFirstPlayerName = homeFirstPlayerName;
    }

    public Integer getHomeSecondPlayerId() {
        return homeSecondPlayerId;
    }

    public void setHomeSecondPlayerId(Integer homeSecondPlayerId) {
        this.homeSecondPlayerId = homeSecondPlayerId;
    }

    public String getHomeSecondPlayerName() {
        return homeSecondPlayerName;
    }

    public void setHomeSecondPlayerName(String homeSecondPlayerName) {
        this.homeSecondPlayerName = homeSecondPlayerName;
    }

    public Integer getAwayFirstPlayerId() {
        return awayFirstPlayerId;
    }

    public void setAwayFirstPlayerId(Integer awayFirstPlayerId) {
        this.awayFirstPlayerId = awayFirstPlayerId;
    }

    public String getAwayFirstPlayerName() {
        return awayFirstPlayerName;
    }

    public void setAwayFirstPlayerName(String awayFirstPlayerName) {
        this.awayFirstPlayerName = awayFirstPlayerName;
    }

    public Integer getAwaySecondPlayerId() {
        return awaySecondPlayerId;
    }

    public void setAwaySecondPlayerId(Integer awaySecondPlayerId) {
        this.awaySecondPlayerId = awaySecondPlayerId;
    }

    public String getAwaySecondPlayerName() {
        return awaySecondPlayerName;
    }

    public void setAwaySecondPlayerName(String awaySecondPlayerName) {
        this.awaySecondPlayerName = awaySecondPlayerName;
    }

    public Integer getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(Integer homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public Integer getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(Integer awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public Integer getRoundId() {
        return roundId;
    }

    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }



}
