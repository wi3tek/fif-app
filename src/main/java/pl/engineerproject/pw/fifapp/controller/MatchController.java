package pl.engineerproject.pw.fifapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.engineerproject.pw.fifapp.mapper.MatchMapper;
import pl.engineerproject.pw.fifapp.dto.MatchDto;
import pl.engineerproject.pw.fifapp.service.MatchService;
import pl.engineerproject.pw.fifapp.service.helper.MatchPlayerRelService;

import java.util.List;

@RestController
@RequestMapping(path = "/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @PostMapping("/addMatch")
    public ResponseEntity addMatch(@RequestBody MatchDto matchDto) {

        return matchService.createMatch(matchDto);
    }

    @Autowired
    MatchPlayerRelService matchPlayerRelService;

    @GetMapping("/getMatch/{matchId}")
    public MatchDto getMatchById(@PathVariable Integer matchId) {
        return matchService.getMatchById(matchId);
    }

    @GetMapping("/getAllMatches")
    public List<MatchDto> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/getRoundMatches/{roundId}")
    public List<MatchDto> getAllMatchesFromRound(@PathVariable Integer roundId) {
        return matchService.getRoundMatches(roundId);
    }

    @RequestMapping(value = "/updateMatch", method = RequestMethod.PUT)
    public void updateMatch(@RequestBody MatchDto matchDto) {
        matchService.editMatch(matchDto);
        matchPlayerRelService.updateMatchPlayerRel( MatchMapper.dtoToEntity(matchDto));
    }

    @RequestMapping(value = "/deleteMatch/{matchId}", method = RequestMethod.DELETE)
    public void deleteMatch(@PathVariable Integer matchId) {
        matchService.deleteMatch(matchId);
    }

    @RequestMapping("/getLeagueMatches/{leagueId}")
    public List<MatchDto> getLeagueMatches(@PathVariable Integer leagueId) {
        return matchService.getLeagueMatches(leagueId);
    }
}
