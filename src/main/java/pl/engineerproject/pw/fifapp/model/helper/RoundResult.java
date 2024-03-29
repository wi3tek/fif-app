package pl.engineerproject.pw.fifapp.model.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@Table(name="rounds_results")
@AllArgsConstructor
@NoArgsConstructor
public class RoundResult {


    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private Integer playerId;
    private String alias;
    private Integer roundId;
    private Integer leagueId;
    private Integer matches;
    private Integer points;
    private Integer wins;
    private Integer draws;
    private Integer loses;
    private Integer goalsScored;
    private Integer goalsConceded;
    private Integer goalsDiff;
    private Double goalsScoredRate;
    private Double goalsConcededRate;
    private Double pointsRate;


}
