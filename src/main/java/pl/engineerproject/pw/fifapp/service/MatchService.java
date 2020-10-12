package pl.engineerproject.pw.fifapp.service;

import org.springframework.http.ResponseEntity;
import pl.engineerproject.pw.fifapp.dto.LeagueDto;
import pl.engineerproject.pw.fifapp.dto.MatchDto;
import pl.engineerproject.pw.fifapp.model.MatchData;

import java.util.List;

public interface MatchService {
    MatchDto getMatchById(Integer matchId);
    void addMatch(MatchDto matchDto);
    void editMatch(MatchDto matchDto);
    List<MatchDto> getAllMatches();
    List<MatchDto> getRoundMatches(Integer roundId);
    void deleteMatch(Integer matchId);
    List<MatchDto> getLeagueMatches(Integer leagueId);
    ResponseEntity createMatch(MatchDto matchDto);
}
