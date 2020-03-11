package pl.engineerproject.pw.fifapp.dto;

import pl.engineerproject.pw.fifapp.model.MatchData;
import pl.engineerproject.pw.fifapp.model.Round;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TeamDto {

    private Integer teamId;
    private String name;
    private Integer overall;
    private String logoUrl;


    public TeamDto(Integer teamId, String name, Integer overall, String logoUrl) {
        this.teamId = teamId;
        this.name = name;
        this.overall = overall;
        this.logoUrl = logoUrl;
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
}
