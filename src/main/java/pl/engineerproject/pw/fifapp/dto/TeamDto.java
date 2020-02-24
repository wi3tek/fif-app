package pl.engineerproject.pw.fifapp.dto;

import pl.engineerproject.pw.fifapp.model.MatchData;

import java.util.ArrayList;
import java.util.List;

public class TeamDto {

    private Integer teamId;
    private String name;
    private Integer overall;
    private String logoUrl;
    private List<MatchDto> matchDtos = new ArrayList<>();


    public TeamDto(Integer teamId, String name, Integer overall, String logoUrl, List<MatchDto> matchDtos) {
        this.teamId = teamId;
        this.name = name;
        this.overall = overall;
        this.logoUrl = logoUrl;
        this.matchDtos = matchDtos;
    }

    public TeamDto() {

    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOverall() {
        return overall;
    }

    public void setOverall(Integer overall) {
        this.overall = overall;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public List<MatchDto> getMatchDtos() {
        return matchDtos;
    }

    public void setMatchDtos(List<MatchDto> matchDtos) {
        this.matchDtos = matchDtos;
    }
}
