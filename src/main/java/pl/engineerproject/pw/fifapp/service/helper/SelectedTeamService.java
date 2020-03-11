package pl.engineerproject.pw.fifapp.service.helper;

import pl.engineerproject.pw.fifapp.model.helper.SelectedTeam;

import java.util.List;

public interface SelectedTeamService {
    List<SelectedTeam> getSelectedTeamByRound(Integer roundId);
}
