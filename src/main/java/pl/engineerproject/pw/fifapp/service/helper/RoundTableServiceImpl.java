package pl.engineerproject.pw.fifapp.service.helper;

import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.engineerproject.pw.fifapp.model.helper.LeagueTable;
import pl.engineerproject.pw.fifapp.model.helper.RoundTable;
import pl.engineerproject.pw.fifapp.repository.helper.RoundTableRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoundTableServiceImpl implements RoundTableService{

    @Autowired
    RoundTableRepository roundTableRepository;


    @Override
    public List<RoundTable> roundTable(Integer leagueId) {
        List<RoundTable> roundTables = roundTableRepository.findAll(Sort.by(Sort.Direction.DESC, "pointsRate"));
        List<RoundTable> resultTable = new ArrayList<>();

        for (RoundTable roundTable : roundTables) {
            if (roundTable.getLeagueId().equals(leagueId)) {
                resultTable.add(roundTable);
            }
        }

        return resultTable;

    }
}
