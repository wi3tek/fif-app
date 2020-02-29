package pl.engineerproject.pw.fifapp.service;

import pl.engineerproject.pw.fifapp.dto.LeagueDto;
import pl.engineerproject.pw.fifapp.dto.MatchDto;

import java.util.List;

public interface MatchService {
    MatchDto getMatchById(Integer matchId);
    void addMatch(MatchDto matchDto);
    void editMatch(MatchDto matchDto);
    List<MatchDto> getAllMatches();
    List<MatchDto> getRoundMatches(Integer roundId);
    void deleteMatch(MatchDto matchDto);


}
