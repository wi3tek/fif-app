package pl.engineerproject.pw.fifapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.engineerproject.pw.fifapp.dto.PlayerDto;
import pl.engineerproject.pw.fifapp.model.helper.PlayerMatch;
import pl.engineerproject.pw.fifapp.service.PlayerService;
import pl.engineerproject.pw.fifapp.service.helper.PlayerMatchService;

import java.util.List;


@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    private final PlayerMatchService playerMatchService;

    @GetMapping("/getPlayer/{playerId}")
    public PlayerDto getPlayerById(@PathVariable Integer playerId) {
        return playerService.getPlayerById(playerId);
    }

    @GetMapping("/getAll")
    public List<PlayerDto> getAllPlayers() {
        return playerService.getPlayers();
    }

    @PostMapping("/create")
    public ResponseEntity createPlayer(@RequestBody PlayerDto playerDto) {
        return playerService.createPlayer(playerDto);
    }

    @PutMapping("/update")
    public void updatelayer(@RequestBody PlayerDto playerDto) {
        playerService.updatePlayer(playerDto);
    }

    @DeleteMapping("/delete/{playerId}")
    public void deletePlayer(@PathVariable Integer playerId) {
        playerService.deletePlayer(playerId);
    }


    @GetMapping("/getMatches/{playerId}")
    public List<PlayerMatch> getPlayerMatches(@PathVariable Integer playerId) {
        return playerMatchService.getPlayerMatches(playerId);
    }

    @GetMapping("/getAllMatches")
    public List<PlayerMatch> getAllMatches() {
        return playerMatchService.getAllMatches();
    }

    @GetMapping("/matchesInLeague/{leagueId}")
    public List<PlayerMatch> getPlayersMatchesInLeague(@PathVariable Integer leagueId) {
        return playerMatchService.getPlayersMatchesInLeague(leagueId);
    }
}