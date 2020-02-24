package pl.engineerproject.pw.fifapp.dto;

import pl.engineerproject.pw.fifapp.model.MatchData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoundDto {

    private Integer roundId;
    private Date roundDate;
    private Integer whichLeagueRound;
    private String description;
    private List<MatchDto> matchDtos = new ArrayList<>();
    private List<LeagueDto> leagueDto = new ArrayList<>();
    private List<TeamDto> teamDtos = new ArrayList<>();


    public RoundDto(Integer roundId, Date roundDate, Integer whichLeagueRound, String description,
                    List<MatchDto> matchDtos, List<LeagueDto> leagueDto, List<TeamDto> teamDtos) {
        this.roundId = roundId;
        this.roundDate = roundDate;
        this.whichLeagueRound = whichLeagueRound;
        this.description = description;
        this.matchDtos = matchDtos;
        this.leagueDto = leagueDto;
        this.teamDtos= teamDtos;
    }


    public RoundDto() {

    }

    public Integer getRoundId() {
        return roundId;
    }

    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    public Date getRoundDate() {
        return roundDate;
    }

    public void setRoundDate(Date roundDate) {
        this.roundDate = roundDate;
    }

    public Integer getWhichLeagueRound() {
        return whichLeagueRound;
    }

    public void setWhichLeagueRound(Integer whichLeagueRound) {
        this.whichLeagueRound = whichLeagueRound;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MatchDto> getMatchDtos() {
        return matchDtos;
    }

    public void setMatchDtos(List<MatchDto> matchDtos) {
        this.matchDtos = matchDtos;
    }

    public List<LeagueDto> getLeagueDto() {
        return leagueDto;
    }

    public void setLeagueDto(List<LeagueDto> leagueDto) {
        this.leagueDto = leagueDto;
    }

    public List<TeamDto> getTeamDtos() {
        return teamDtos;
    }

    public void setTeamDtos(List<TeamDto> teamDtos) {
        this.teamDtos = teamDtos;
    }
}



