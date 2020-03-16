package pl.engineerproject.pw.fifapp.service.helper;

import pl.engineerproject.pw.fifapp.dto.TeamDto;
import pl.engineerproject.pw.fifapp.model.helper.SelectedTeam;

import java.util.List;
import java.util.Map;

public interface SelectedTeamService {
    List<Integer> getSelectedTeamIdsByRound(Integer roundId);
    Map<Integer, String> getTeamsToChose(Integer roundId, List<TeamDto> allTeams);
}
