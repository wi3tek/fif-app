package pl.engineerproject.pw.fifapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.engineerproject.pw.fifapp.dto.TeamDto;
import pl.engineerproject.pw.fifapp.model.Team;
import pl.engineerproject.pw.fifapp.model.helper.SelectedTeam;
import pl.engineerproject.pw.fifapp.service.TeamService;
import pl.engineerproject.pw.fifapp.service.helper.SelectedTeamService;

import java.util.ArrayList;
import java.util.List;

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
    public List<TeamDto> getTeamToSelect(@PathVariable Integer roundId) {
        List<TeamDto> allTeams = teamService.getTeamsList();
        List<SelectedTeam> selectedTeams = selectedTeamService.getSelectedTeamByRound(roundId);

        List<Integer> selectedTeamsIdList = new ArrayList<>();

        if(!selectedTeams.isEmpty()) {
            for (int i = 0; i < selectedTeams.size(); i++) {
                if (selectedTeams.get(i).getRoundId().equals(roundId)) {
                    selectedTeamsIdList.add(selectedTeams.get(i).getTeamId());
                    System.out.println("DODANO DRUŻYNĘ: "+selectedTeams.get(i).getTeamId());
                }
            }

            if (!selectedTeamsIdList.isEmpty()) {
                for (int i = 0; i < allTeams.size(); i++) {
                    for (int j = 0; j < selectedTeamsIdList.size(); j++) {
                        if (allTeams.get(i).getTeamId().equals(selectedTeamsIdList.get(j))) {
                            allTeams.remove(allTeams.get(i));
                            System.out.println("WYWALONO DRUŻYNĘ name: "+allTeams.get(i).getName());
                            System.out.println("WYWALONO DRUŻYNĘ id: "+allTeams.get(i).getTeamId());
                        }
                    }
                }
            }
        }

        return allTeams;
    }
}
