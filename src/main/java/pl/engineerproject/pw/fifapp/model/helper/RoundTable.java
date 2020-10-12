package pl.engineerproject.pw.fifapp.model.helper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="rounds_table")
public class RoundTable implements Serializable {
    private static final long serialVersionUID = -5354143979341385780L;

    @Column(name = "id")
    @Id
    private Integer viewId;
    @Column(name = "Gracz")
    private Integer playerId;
    @Column(name = "ALIAS")
    private String alias;
    @Column(name = "Kolejka")
    private Integer roundId;
    @Column(name = "Liga")
    private Integer leagueId;
    @Column(name = "Mecze")
    private Integer matches;
    @Column(name = "Punkty")
    private Integer points;
    @Column(name = "Zwyciestwa")
    private Integer wins;
    @Column(name = "Remisy")
    private Integer draws;
    @Column(name = "Porazki")
    private Integer loses;
    @Column(name = "Zdobyte")
    private Integer goalsScored;
    @Column(name = "Stracone")
    private Integer goalsConceded;
    @Column(name = "BILANS")
    private Integer goalsDiff;
    @Column
    private Double goalsScoredRate;
    @Column
    private Double goalsConcededRate;
    @Column
    private Double pointsRate;


    public RoundTable(Integer viewId, Integer playerId, String alias, Integer roundId, Integer leagueId, Integer matches,
                       Integer points, Integer wins, Integer draws, Integer loses, Integer goalsScored,
                       Integer goalsConceded, Integer goalsDiff, Double goalsScoredRate, Double goalsConcededRate,
                       Double pointsRate) {
        this.viewId = viewId;
        this.playerId = playerId;
        this.alias = alias;
        this.roundId = roundId;
        this.leagueId = leagueId;
        this.matches = matches;
        this.points = points;
        this.wins = wins;
        this.draws = draws;
        this.loses = loses;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        this.goalsDiff = goalsDiff;
        this.goalsScoredRate = goalsScoredRate;
        this.goalsConcededRate = goalsConcededRate;
        this.pointsRate = pointsRate;
    }


    public RoundTable() {

    }

    public Integer getViewId() {
        return viewId;
    }

    public void setViewId(Integer viewId) {
        this.viewId = viewId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getRoundId() {
        return roundId;
    }

    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getDraws() {
        return draws;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public Integer getLoses() {
        return loses;
    }

    public void setLoses(Integer loses) {
        this.loses = loses;
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

    public Double getGoalsScoredRate() {
        return goalsScoredRate;
    }

    public void setGoalsScoredRate(Double goalsScoredRate) {
        this.goalsScoredRate = goalsScoredRate;
    }

    public Double getGoalsConcededRate() {
        return goalsConcededRate;
    }

    public void setGoalsConcededRate(Double goalsConcededRate) {
        this.goalsConcededRate = goalsConcededRate;
    }

    public Double getPointsRate() {
        return pointsRate;
    }

    public void setPointsRate(Double pointsRate) {
        this.pointsRate = pointsRate;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }
}
