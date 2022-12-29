package pl.engineerproject.pw.fifapp.service.helper;

import pl.engineerproject.pw.fifapp.model.helper.LeagueTable;

import java.util.List;

public interface LeagueTableService {

    List<LeagueTable> getFullLeagueTable(Integer leagueId);

    List<LeagueTable> getLeagueTable(Integer leagueId);
}
