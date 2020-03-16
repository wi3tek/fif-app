package pl.engineerproject.pw.fifapp.model.helper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="player_matches")
public class PlayerMatch implements Serializable {
    private static final long serialVersionUID = 6132995958459935637L;

    @Column(name="PLAYER_MATCHES_ID")
    @Id
    private String pmId;
    @Column(name ="match_id")
    private Integer matchId;
    @Column(name ="match_date")
    private LocalDateTime matchDate;
    @Column(name ="PLAYER_ID")
    private Integer playerId;
    @Column(name ="PLAYER_ALIAS")
    private String playerAlias;
    @Column(name ="MATCH_ROLE")
    private String matchRole;
    @Column(name ="TEAM_ID")
    private Integer teamId;
    @Column(name ="TEAM")
    private String teamName;
    @Column(name ="TEAM_LOGO_URL")
    private String teamLigiUrl;
    @Column(name ="GOALS_SCORED")
    private Integer goalsScored;
    @Column(name ="GOALS_CONCEDED")
    private Integer goalsConceded;
    @Column(name ="GOALS_DIFF")
    private Integer goalsDiff;
    @Column(name ="RESULT_FLAG")
    private String resultFlag;
    @Column(name ="FIRST_OPPONENT")
    private Integer firstOpponentId;
    @Column(name ="FIRST_OPPONENT_NAME")
    private String firstOpponentName;
    @Column(name ="SECOND_OPPONENT")
    private Integer secondOpponentId;
    @Column(name ="SECOND_OPPONENT_NAME")
    private String secondOpponentName;
    @Column(name ="TEAM_OPPONENT_ID")
    private Integer teamOpponentsId;
    @Column(name ="TEAM_OPPONENT")
    private String teamOpponents;
    @Column(name ="TEAM_OPPONENT_LOGO")
    private String teamOpponentsLogo;
    @Column(name="LEAGUE_ID")
    private Integer leagueId;
    @Column(name="ROUND_ID")
    private Integer roundId;

    public PlayerMatch(String pmId, Integer matchId, LocalDateTime matchDate, Integer playerId, String playerAlias,
                       String matchRole, Integer teamId, String teamName, String teamLigiUrl, Integer goalsScored,
                       Integer goalsConceded, Integer goalsDiff, String resultFlag, Integer firstOpponentId,
                       String firstOpponentName, Integer secondOpponentId, String secondOpponentName,
                       Integer teamOpponentsId, String teamOpponents, String teamOpponentsLogo, Integer leagueId,
                       Integer roundId) {
        this.pmId = pmId;
        this.matchId = matchId;
        this.matchDate = matchDate;
        this.playerId = playerId;
        this.playerAlias = playerAlias;
        this.matchRole = matchRole;
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamLigiUrl = teamLigiUrl;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        this.goalsDiff = goalsDiff;
        this.resultFlag = resultFlag;
        this.firstOpponentId = firstOpponentId;
        this.firstOpponentName = firstOpponentName;
        this.secondOpponentId = secondOpponentId;
        this.secondOpponentName = secondOpponentName;
        this.teamOpponentsId = teamOpponentsId;
        this.teamOpponents = teamOpponents;
        this.teamOpponentsLogo = teamOpponentsLogo;
        this.leagueId = leagueId;
        this.roundId = roundId;
    }

    public PlayerMatch() {

    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public Integer getRoundId() {
        return roundId;
    }

    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    public String getPmId() {
        return pmId;
    }

    public void setPmId(String pmId) {
        this.pmId = pmId;
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

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerAlias() {
        return playerAlias;
    }

    public void setPlayerAlias(String playerAlias) {
        this.playerAlias = playerAlias;
    }

    public String getMatchRole() {
        return matchRole;
    }

    public void setMatchRole(String matchRole) {
        this.matchRole = matchRole;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLigiUrl() {
        return teamLigiUrl;
    }

    public void setTeamLigiUrl(String teamLigiUrl) {
        this.teamLigiUrl = teamLigiUrl;
    }

    public Integer getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(Integer goalsScored) {
        this.goalsScored = goalsScored;
    }

    public Integer getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(Integer goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public Integer getGoalsDiff() {
        return goalsDiff;
    }

    public void setGoalsDiff(Integer goalsDiff) {
        this.goalsDiff = goalsDiff;
    }

    public String getResultFlag() {
        return resultFlag;
    }

    public void setResultFlag(String resultFlag) {
        this.resultFlag = resultFlag;
    }

    public Integer getFirstOpponentId() {
        return firstOpponentId;
    }

    public void setFirstOpponentId(Integer firstOpponentId) {
        this.firstOpponentId = firstOpponentId;
    }

    public String getFirstOpponentName() {
        return firstOpponentName;
    }

    public void setFirstOpponentName(String firstOpponentName) {
        this.firstOpponentName = firstOpponentName;
    }

    public Integer getSecondOpponentId() {
        return secondOpponentId;
    }

    public void setSecondOpponentId(Integer secondOpponentId) {
        this.secondOpponentId = secondOpponentId;
    }

    public String getSecondOpponentName() {
        return secondOpponentName;
    }

    public void setSecondOpponentName(String secondOpponentName) {
        this.secondOpponentName = secondOpponentName;
    }

    public Integer getTeamOpponentsId() {
        return teamOpponentsId;
    }

    public void setTeamOpponentsId(Integer teamOpponentsId) {
        this.teamOpponentsId = teamOpponentsId;
    }

    public String getTeamOpponents() {
        return teamOpponents;
    }

    public void setTeamOpponents(String teamOpponents) {
        this.teamOpponents = teamOpponents;
    }

    public String getTeamOpponentsLogo() {
        return teamOpponentsLogo;
    }

    public void setTeamOpponentsLogo(String teamOpponentsLogo) {
        this.teamOpponentsLogo = teamOpponentsLogo;
    }
}


