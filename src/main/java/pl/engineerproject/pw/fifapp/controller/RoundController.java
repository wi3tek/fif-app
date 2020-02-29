package pl.engineerproject.pw.fifapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.engineerproject.pw.fifapp.dto.RoundDto;
import pl.engineerproject.pw.fifapp.service.RoundService;

import java.util.List;

@RestController
@RequestMapping(path="/rounds")
public class RoundController {

    @Autowired
    RoundService roundService;

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

}
