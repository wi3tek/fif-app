package pl.engineerproject.pw.fifapp.service;

import pl.engineerproject.pw.fifapp.dto.TeamDto;

import java.util.List;

public interface TeamService {
    List<TeamDto> getTeamsList();
    TeamDto getTeamById(Integer teamId);
    void addTeam(TeamDto teamDto);
    void deleteTeam(TeamDto teamDto);
}

