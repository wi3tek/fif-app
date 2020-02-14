package pl.engineerproject.pw.fifapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.engineerproject.pw.fifapp.dto.LeagueDto;
import pl.engineerproject.pw.fifapp.model.League;
import pl.engineerproject.pw.fifapp.repository.LeagueRepository;
import javassist.tools.web.BadHttpRequest;
import pl.engineerproject.pw.fifapp.service.LeagueService;

import java.util.List;

@RestController
@RequestMapping(path = "/leagues")
public class LeagueController {

    @Autowired //adnotacja powoduje, że nie trzeba tworzyć obiekty danej klasy, gdyż jest on tworzony automatycznie
    LeagueService leagueService;

    @RequestMapping("/getLeague/{leagueId}")
    public LeagueDto getLeagueById(@PathVariable Integer leagueId) {
        return leagueService.getLeagueById(leagueId);
    }

    @RequestMapping("/getAllLeagues")
    public List<LeagueDto> getAllLeagues() {
        System.out.println("Zawołałe musługę getAllLeagues()");
        return leagueService.getAllLeagues();
    }

    @RequestMapping(value="saveLeague", method = RequestMethod.POST)
    public void saveLeague(@RequestBody LeagueDto leagueDto) {
        leagueService.saveLeague(leagueDto);
    }
}
