package pl.engineerproject.pw.fifapp.service.helper;

import pl.engineerproject.pw.fifapp.model.helper.LeagueTable;
import pl.engineerproject.pw.fifapp.model.helper.RoundTable;

import java.util.List;

public interface RoundTableService {
    List<RoundTable> roundTable(Integer leagueId);
}
