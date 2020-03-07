package pl.engineerproject.pw.fifapp.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.engineerproject.pw.fifapp.model.helper.LeagueTable;
import pl.engineerproject.pw.fifapp.repository.helper.LeagueTableRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeagueTableServiceImpl implements LeagueTableService {

    @Autowired
    LeagueTableRepository leagueTableRepository;


    @Override
    public List<LeagueTable> getLeagueTable(Integer leagueId) {
        List<LeagueTable> allLeagues = leagueTableRepository.findAll(Sort.by(Sort.Direction.DESC, "pointsRate"));
        List<LeagueTable> leagueTable = new ArrayList<>();
        for (int i = 0; i <allLeagues.size() ; i++) {
            if(allLeagues.get(i).getLeagueId().equals(leagueId)) {
                leagueTable.add(allLeagues.get(i));
            }
        }
        return leagueTable;
    }
}
