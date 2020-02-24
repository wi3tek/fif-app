package pl.engineerproject.pw.fifapp.dto;

import java.util.ArrayList;
import java.util.List;

public class LeagueDto {

    private Integer leagueId;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String location;
    private List<RoundDto> roundDtos = new ArrayList<>();

    public LeagueDto(Integer leagueId, String name, String description, String startDate, String endDate, String location, List<RoundDto> roundDtos) {
        this.leagueId=leagueId;
        this.name=name;
        this.description=description;
        this.startDate=startDate;
        this.endDate=endDate;
        this.location=location;
        this.roundDtos=roundDtos;
    }

    public LeagueDto() {

    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<RoundDto> getRoundDtos() {
        return roundDtos;
    }

    public void setRoundDtos(List<RoundDto> roundDtos) {
        this.roundDtos = roundDtos;
    }
}
