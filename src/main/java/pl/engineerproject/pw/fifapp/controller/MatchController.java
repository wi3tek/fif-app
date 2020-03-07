package pl.engineerproject.pw.fifapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.engineerproject.pw.fifapp.converter.MatchConverter;
import pl.engineerproject.pw.fifapp.dto.MatchDto;
import pl.engineerproject.pw.fifapp.service.MatchService;
import pl.engineerproject.pw.fifapp.service.helper.MatchPlayerRelService;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping(path = "/matches")
public class MatchController {


    @Autowired
    MatchService matchService;

    @Autowired
    MatchPlayerRelService matchPlayerRelService;

    @RequestMapping("/getMatch/{matchId}")
    public MatchDto getMatchById(@PathVariable Integer matchId) {
        return matchService.getMatchById(matchId);
    }

    @RequestMapping("/getAllMatches")
    public List<MatchDto> getAllMatches() {
        return matchService.getAllMatches();
    }

    @RequestMapping("/getRoundMatches/{roundId}")
    public List<MatchDto> getAllMatchesFromRound(@PathVariable Integer roundId) {
        return matchService.getRoundMatches(roundId);
    }

    @RequestMapping(value="/addMatch", method = RequestMethod.POST)
    public ResponseEntity addMatch(@RequestBody MatchDto matchDto) {

        return matchService.createMatch(matchDto);

    }

    @RequestMapping(value = "/updateMatch", method = RequestMethod.PUT)
    public void updateMatch(@RequestBody MatchDto matchDto) {
        matchService.editMatch(matchDto);
        matchPlayerRelService.updateMatchPlayerRel(MatchConverter.dtoToEntity(matchDto));
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
