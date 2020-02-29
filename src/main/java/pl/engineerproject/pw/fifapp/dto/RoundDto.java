package pl.engineerproject.pw.fifapp.dto;

import pl.engineerproject.pw.fifapp.model.League;
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

    public List<TeamDto> getTeamDtos() {
        return teamDtos;
    }

    public void setTeamDtos(List<TeamDto> teamDtos) {
        this.teamDtos = teamDtos;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLeagueDescription() {
        return leagueDescription;
    }

    public void setLeagueDescription(String leagueDescription) {
        this.leagueDescription = leagueDescription;
    }

    public String getLeagueStartDate() {
        return leagueStartDate;
    }

    public void setLeagueStartDate(String leagueStartDate) {
        this.leagueStartDate = leagueStartDate;
    }

    public String getLeagueEndDate() {
        return leagueEndDate;
    }

    public void setLeagueEndDate(String leagueEndDate) {
        this.leagueEndDate = leagueEndDate;
    }

    public String getLeagueLocation() {
        return leagueLocation;
    }

    public void setLeagueLocation(String leagueLocation) {
        this.leagueLocation = leagueLocation;
    }
}



