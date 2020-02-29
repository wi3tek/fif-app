package pl.engineerproject.pw.fifapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.engineerproject.pw.fifapp.dto.MatchDto;
import pl.engineerproject.pw.fifapp.service.MatchService;

import java.util.List;

@RestController
@RequestMapping(path = "/matches")
public class MatchController {


    @Autowired
    MatchService matchService;

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
    public void addMatch(@RequestBody MatchDto matchDto) {
        matchService.addMatch(matchDto);
    }

    @RequestMapping(value = "/updateMatch", method = RequestMethod.PUT)
    public void updateMatch(@RequestBody MatchDto matchDto) {
        matchService.editMatch(matchDto);
    }

    @RequestMapping(value = "/deleteMatch", method = RequestMethod.DELETE)
    public void deleteMatch(@RequestBody MatchDto matchDto) {
        matchService.deleteMatch(matchDto);
    }
}
