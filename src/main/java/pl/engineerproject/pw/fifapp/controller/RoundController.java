package pl.engineerproject.pw.fifapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.engineerproject.pw.fifapp.dto.RoundDto;
import pl.engineerproject.pw.fifapp.model.helper.LeagueTable;
import pl.engineerproject.pw.fifapp.model.helper.RoundTable;
import pl.engineerproject.pw.fifapp.service.RoundService;
import pl.engineerproject.pw.fifapp.service.helper.RoundTableService;

import java.util.List;

@RestController
@RequestMapping(path="/rounds")
public class RoundController {

    @Autowired
    RoundService roundService;

    @Autowired
    RoundTableService roundTableService;

    @RequestMapping("/getRound/{roundId}")
    public RoundDto getRoundById(@PathVariable Integer roundId) {
        return roundService.getRoundById(roundId);
    }

    @RequestMapping("/getAllRounds")
    public List<RoundDto> getAllRounds() {
        return roundService.getAllRounds();
    }

    @RequestMapping("/getLeagueRounds/{leagueId}")
    public List<RoundDto> getLeagueRounds(@PathVariable Integer leagueId) {
        return roundService.getLeagueRounds(leagueId);
    }

    @RequestMapping(value="/addRound", method = RequestMethod.POST)
    public void addRound(@RequestBody RoundDto roundDto) {
        roundService.saveRound(roundDto);
    }

    @RequestMapping(value = "/deleteRound/{roundId}", method = RequestMethod.DELETE)
    public void deleteMatch(@PathVariable Integer roundId) {
        roundService.deleteRoundById(roundId);
    }

    @RequestMapping(value = "/roundTable/{leagueId}")
    public List<RoundTable> roundTable(@PathVariable Integer leagueId) {
        return roundTableService.roundTable(leagueId);
    }
}
