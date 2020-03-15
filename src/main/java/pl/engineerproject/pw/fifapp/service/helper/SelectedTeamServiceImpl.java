package pl.engineerproject.pw.fifapp.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.engineerproject.pw.fifapp.dto.TeamDto;
import pl.engineerproject.pw.fifapp.model.helper.SelectedTeam;
import pl.engineerproject.pw.fifapp.repository.helper.SelectedTeamRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SelectedTeamServiceImpl implements SelectedTeamService {

    @Autowired
    SelectedTeamRepository selectedTeamRepository;


    @Override
    public List<Integer> getSelectedTeamIdsByRound(Integer roundId) {
        List<SelectedTeam> allSelectedTeams = selectedTeamRepository.findAll();
        List<Integer> result = new ArrayList<>();

        for (SelectedTeam allSelectedTeam : allSelectedTeams) {
            if (allSelectedTeam.getRoundId().equals(roundId)) {
                result.add(allSelectedTeam.getTeamId());
            }
        }

        System.out.println(result);
        return result;
    }

    @Override
    public Map<Integer, String> getTeamsToChose(Integer roundId, List<TeamDto> allTeams) {
        List<Integer> selectedTeamIds = getSelectedTeamIdsByRound(roundId);
        Map<Integer, String> teamsToChose = new HashMap<>();

        if(!allTeams.isEmpty()) {
            for (TeamDto team : allTeams) {
                teamsToChose.put(team.getTeamId(), team.getName());
            }
        }

        if(!selectedTeamIds.isEmpty()) {
            for (Integer teamId : selectedTeamIds) {
                teamsToChose.remove(teamId);
            }
        }

        return teamsToChose;
    }
}
