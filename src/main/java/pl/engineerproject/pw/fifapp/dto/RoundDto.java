package pl.engineerproject.pw.fifapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.engineerproject.pw.fifapp.model.League;
import pl.engineerproject.pw.fifapp.model.MatchData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RoundDto {

    private Integer roundId;
    private Date roundDate;
    private Integer whichLeagueRound;
    private String description;
    private List<MatchDto> matchDtos = new ArrayList<>();
    private List<TeamDto> teamDtos = new ArrayList<>();

    private Integer leagueId;
    private String leagueName;
    private String leagueDescription;
    private String leagueStartDate;
    private String leagueEndDate;
    private String leagueLocation;

    public RoundDto(Integer roundId, Date roundDate, Integer whichLeagueRound, String description,
                    List<MatchDto> matchDtos, List<TeamDto> teamDtos) {
        this.roundId = roundId;
        this.roundDate = roundDate;
        this.whichLeagueRound = whichLeagueRound;
        this.description = description;
        this.matchDtos = matchDtos;
        this.teamDtos= teamDtos;
    }
}



