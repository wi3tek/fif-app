package pl.engineerproject.pw.fifapp.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.engineerproject.pw.fifapp.model.helper.SelectedTeam;
import pl.engineerproject.pw.fifapp.repository.helper.SelectedTeamRepository;

import java.util.List;

@Service
public class SelectedTeamServiceImpl implements SelectedTeamService {

    @Autowired
    SelectedTeamRepository selectedTeamRepository;


    @Override
    public List<SelectedTeam> getSelectedTeamByRound(Integer roundId) {
        return selectedTeamRepository.findAll();
    }
}
