package pl.engineerproject.pw.fifapp.model.helper;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class MatchPlayerRel implements Serializable {

    private static final long serialVersionUID = 5086348247923661608L;

    @Column
    @Id
    private String matchPlayerRelId;
    @Column
    private Integer matchId;
    @Column
    private Integer playerId;
    @Column
    private Integer points;
    @Column
    private Integer goalsScored;
    @Column
    private Integer goalsConceded;
    @Column
    private Integer winFlag;
    @Column
    private Integer drawFlag;
    @Column
    private Integer loseFlag;
    @Column
    private Integer goalsDiff;
    @Column
    private LocalDateTime updateDate;
    @Column
    private String playerMatchRole;


    public String getMatchPlayerRelId() {
        return matchPlayerRelId;
    }

    public void setMatchPlayerRelId(String matchPlayerRelId) {
        this.matchPlayerRelId = matchPlayerRelId;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
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

    public Integer getWinFlag() {
        return winFlag;
    }

    public void setWinFlag(Integer winFlag) {
        this.winFlag = winFlag;
    }

    public Integer getDrawFlag() {
        return drawFlag;
    }

    public void setDrawFlag(Integer drawFlag) {
        this.drawFlag = drawFlag;
    }

    public Integer getLoseFlag() {
        return loseFlag;
    }

    public void setLoseFlag(Integer loseFlag) {
        this.loseFlag = loseFlag;
    }

    public Integer getGoalsDiff() {
        return goalsDiff;
    }

    public void setGoalsDiff(Integer goalsDiff) {
        this.goalsDiff = goalsDiff;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getPlayerMatchRole() {
        return playerMatchRole;
    }

    public void setPlayerMatchRole(String playerMatchRole) {
        this.playerMatchRole = playerMatchRole;
    }

    public MatchPlayerRel(String matchPlayerRelId, Integer playerId, Integer points, Integer goalsScored, Integer goalsConceded,
                          Integer winFlag, Integer drawFlag, Integer loseFlag, Integer goalsDiff,
                          LocalDateTime updateDate, String playerMatchRole, Integer matchId) {
        this.matchPlayerRelId = matchPlayerRelId;
        this.playerId = playerId;
        this.points = points;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        this.winFlag = winFlag;
        this.drawFlag = drawFlag;
        this.loseFlag = loseFlag;
        this.goalsDiff = goalsDiff;
        this.updateDate = updateDate;
        this.playerMatchRole = playerMatchRole;
        this.matchId = matchId;

    }

    public MatchPlayerRel() {

    }

}
