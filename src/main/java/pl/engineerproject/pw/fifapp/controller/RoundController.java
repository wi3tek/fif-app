package pl.engineerproject.pw.fifapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.engineerproject.pw.fifapp.dto.RoundDto;
import pl.engineerproject.pw.fifapp.model.helper.RoundResult;
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

    @GetMapping("/getRound/{roundId}")
    public RoundDto getRoundById(@PathVariable Integer roundId) {
        return roundService.getRoundById(roundId);
    }

    @GetMapping("/getAllRounds")
    public List<RoundDto> getAllRounds() {
        return roundService.getAllRounds();
    }

    @GetMapping("/getLeagueRounds/{leagueId}")
    public List<RoundDto> getLeagueRounds(@PathVariable Integer leagueId) {
        return roundService.getLeagueRounds(leagueId);
    }

    @PostMapping("/addRound")
    public void addRound(@RequestBody RoundDto roundDto) {
        roundService.saveRound(roundDto);
    }

    @DeleteMapping("/deleteRound/{roundId}")
    public void deleteMatch(@PathVariable Integer roundId) {
        roundService.deleteRoundById(roundId);
    }

    @GetMapping("/roundTable/{leagueId}")
    public List<RoundResult> roundTable(@PathVariable Integer leagueId) {
        return roundTableService.roundTable(leagueId);
    }
}
