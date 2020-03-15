package pl.engineerproject.pw.fifapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.engineerproject.pw.fifapp.dto.TeamDto;
import pl.engineerproject.pw.fifapp.service.TeamService;
import pl.engineerproject.pw.fifapp.service.helper.SelectedTeamService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/teams")
public class TeamController {


    @Autowired
    SelectedTeamService selectedTeamService;

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

    @RequestMapping("/initTeamsList/{roundId}")
    public Map<Integer, String> getTeamToSelect(@PathVariable Integer roundId) {
        return selectedTeamService.getTeamsToChose(roundId, teamService.getTeamsList());
    }
}
