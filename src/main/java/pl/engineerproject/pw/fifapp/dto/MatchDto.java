package pl.engineerproject.pw.fifapp.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class MatchDto {

    private Integer matchId;
    private LocalDateTime matchDate;
    private Integer homeFirstPlayerId;
    private String homeFirstPlayerAlias;

    private Integer homeSecondPlayerId;
    private String homeSecondPlayerAlias;

    private Integer awayFirstPlayerId;
    private String awayFirstPlayerAlias;

    private Integer awaySecondPlayerId;
    private String awaySecondPlayerAlias;

    private Integer homeGoals;
    private Integer awayGoals;

    private Integer homeTeamId;
    private String homeTeamLogoUrl;
    private String homeTeamName;

    private Integer awayTeamId;
    private String awayTeamLogoUrl;
    private String awayTeamName;

    private String comment;
    private LocalDateTime updateDate;
    private Character matchType;
    private Integer roundId;
    private Integer leagueId;

    public MatchDto(Integer matchId, LocalDateTime matchDate,Integer homeGoals, Integer awayGoals,String comment, LocalDateTime updateDate, Character matchType) {
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

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDateTime matchDate) {
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

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
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

    public String getHomeFirstPlayerAlias() {
        return homeFirstPlayerAlias;
    }

    public void setHomeFirstPlayerAlias(String homeFirstPlayerName) {
        this.homeFirstPlayerAlias = homeFirstPlayerName;
    }

    public Integer getHomeSecondPlayerId() {
        return homeSecondPlayerId;
    }

    public void setHomeSecondPlayerId(Integer homeSecondPlayerId) {
        this.homeSecondPlayerId = homeSecondPlayerId;
    }

    public String getHomeSecondPlayerAlias() {
        return homeSecondPlayerAlias;
    }

    public void setHomeSecondPlayerAlias(String homeSecondPlayerName) {
        this.homeSecondPlayerAlias = homeSecondPlayerName;
    }

    public Integer getAwayFirstPlayerId() {
        return awayFirstPlayerId;
    }

    public void setAwayFirstPlayerId(Integer awayFirstPlayerId) {
        this.awayFirstPlayerId = awayFirstPlayerId;
    }

    public String getAwayFirstPlayerAlias() {
        return awayFirstPlayerAlias;
    }

    public void setAwayFirstPlayerAlias(String awayFirstPlayerName) {
        this.awayFirstPlayerAlias = awayFirstPlayerName;
    }

    public Integer getAwaySecondPlayerId() {
        return awaySecondPlayerId;
    }

    public void setAwaySecondPlayerId(Integer awaySecondPlayerId) {
        this.awaySecondPlayerId = awaySecondPlayerId;
    }

    public String getAwaySecondPlayerAlias() {
        return awaySecondPlayerAlias;
    }

    public void setAwaySecondPlayerAlias(String awaySecondPlayerName) {
        this.awaySecondPlayerAlias = awaySecondPlayerName;
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

    public String getHomeTeamLogoUrl() {
        return homeTeamLogoUrl;
    }

    public void setHomeTeamLogoUrl(String homeTeamLogoUrl) {
        this.homeTeamLogoUrl = homeTeamLogoUrl;
    }

    public String getAwayTeamLogoUrl() {
        return awayTeamLogoUrl;
    }

    public void setAwayTeamLogoUrl(String awayTeamLogoUrl) {
        this.awayTeamLogoUrl = awayTeamLogoUrl;
    }
}
