package pl.engineerproject.pw.fifapp.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.engineerproject.pw.fifapp.model.helper.LeagueTable;
import pl.engineerproject.pw.fifapp.repository.helper.LeagueTableRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class LeagueTableServiceImpl implements LeagueTableService {

    @Autowired
    LeagueTableRepository leagueTableRepository;


    @Override
    public List<LeagueTable> getFullLeagueTable(Integer leagueId) {
        List<LeagueTable> allLeagues = leagueTableRepository.findAll(Sort.by(Sort.Direction.DESC, "pointsRate"));
        List<LeagueTable> leagueTable = new ArrayList<>();
        for (LeagueTable allLeague : allLeagues) {
            if (allLeague.getLeagueId().equals(leagueId)) {
                leagueTable.add(allLeague);
            }
        }
        return leagueTable;
    }
    @Override
    public List<LeagueTable> getLeagueTable(Integer leagueId) {
//        List<LeagueTable> allLeagues = leagueTableRepository.findAll(Sort.by(Sort.Direction.DESC, "pointsRate"));
        //Sort.by(Sort.Direction.DESC, "pointsRate")

        System.out.println("HALO KURDE");
        List<LeagueTable> leagueData = leagueTableRepository.findByLeagueId(leagueId);
        return leagueData.stream()
                .filter(league -> league.getMatches()>5)
                .sorted(Comparator.comparing(LeagueTable::getPointsRate).thenComparing(LeagueTable::getGoalsScoredRate).thenComparing(LeagueTable::getGoalsConceded).reversed())
                .parallel()
                .toList();
    }
}
