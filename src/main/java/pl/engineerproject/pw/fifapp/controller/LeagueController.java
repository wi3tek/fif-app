package pl.engineerproject.pw.fifapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.engineerproject.pw.fifapp.dto.LeagueDto;
import pl.engineerproject.pw.fifapp.model.helper.LeagueTable;
import pl.engineerproject.pw.fifapp.service.LeagueService;
import pl.engineerproject.pw.fifapp.service.helper.LeagueTableService;

import java.util.List;

@RestController
@RequestMapping(path = "/leagues")
@RequiredArgsConstructor
public class LeagueController {

    private final LeagueService leagueService;
    private final LeagueTableService leagueTableService;

    @GetMapping("/getLeague/{leagueId}")
    public LeagueDto getLeagueById(@PathVariable Integer leagueId) {
        return leagueService.getLeagueById(leagueId);
    }

    @GetMapping("/getAllLeagues")
    public List<LeagueDto> getAllLeagues() {
        System.out.println("Zawołałe musługę getAllLeagues()");
        return leagueService.getAllLeagues();
    }

    @PostMapping("/saveLeague")
    public void saveLeague(@RequestBody LeagueDto leagueDto) {
        leagueService.saveLeague(leagueDto);
    }

    @PutMapping("/update")
    public void updateLeague(@RequestBody LeagueDto leagueDto) {
        leagueService.updateLeague(leagueDto);
    }

    @GetMapping("/delete/{leagueId}")
    public void deleteLeague(@PathVariable Integer leagueId) {
        leagueService.deleteLeague(leagueId);
    }

    @GetMapping("/getLeagueTable/{leagueId}")
    public List<LeagueTable> getLeagueTable(@PathVariable Integer leagueId) {
        return leagueTableService.getLeagueTable(leagueId);
    }
}
