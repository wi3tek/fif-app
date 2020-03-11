package pl.engineerproject.pw.fifapp.service.helper;

import pl.engineerproject.pw.fifapp.model.helper.PlayerMatch;

import java.util.List;

public interface PlayerMatchService {

    List<PlayerMatch> getPlayerMatches(Integer PlayerId);
    List<PlayerMatch> getAllMatches();
}
