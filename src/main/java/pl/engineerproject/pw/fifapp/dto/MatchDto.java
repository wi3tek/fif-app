package pl.engineerproject.pw.fifapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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
}
