package pl.engineerproject.pw.fifapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.engineerproject.pw.fifapp.model.helper.LeagueTable;
import pl.engineerproject.pw.fifapp.service.helper.LeagueTableService;

import java.util.List;

@RestController
@RequestMapping(path = "/leagues")
public class LegaueTableController {

    @Autowired
    LeagueTableService leagueTableService;

    @GetMapping("/getLeagueTable/{leagueId}")
    public List<LeagueTable> getLeagueTable(@PathVariable Integer leagueId) {
        return leagueTableService.getLeagueTable(leagueId);
    }
}
