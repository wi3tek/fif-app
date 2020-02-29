package pl.engineerproject.pw.fifapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.engineerproject.pw.fifapp.dto.TeamDto;
import pl.engineerproject.pw.fifapp.service.TeamService;

import java.util.List;

@RestController
@RequestMapping(path = "/teams")
public class TeamController {

    @Autowired
    TeamService teamService;


    @RequestMapping("/getTeam/{teamId}")
    public TeamDto getTeam(@PathVariable Integer teamId) {
        return teamService.getTeamById(teamId);
    }

    @RequestMapping("/getAllTeams")
    public List<TeamDto> getAllTeams() {
        return teamService.getTeamsList();
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public void createTeam(@RequestBody TeamDto teamDto) {
        teamService.addTeam(teamDto);
    }

    @RequestMapping(value="/delete", method = RequestMethod.DELETE)
    public void deleteTeam(@RequestBody TeamDto teamDto) {
        teamService.deleteTeam(teamDto);
    }

}
