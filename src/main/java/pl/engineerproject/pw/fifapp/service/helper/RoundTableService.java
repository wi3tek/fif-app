package pl.engineerproject.pw.fifapp.service.helper;

import pl.engineerproject.pw.fifapp.model.helper.RoundResult;

import java.util.List;

public interface RoundTableService {
    List<RoundResult> roundTable(Integer leagueId);
}
