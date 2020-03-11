package pl.engineerproject.pw.fifapp.controller;

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
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerMatchService playerMatchService;

    @RequestMapping("/getPlayer/{playerId}")
    public PlayerDto getPlayerById(@PathVariable Integer playerId) {
        return playerService.getPlayerById(playerId);
    }

    @RequestMapping("/getAll")
    public List<PlayerDto> getAllPlayers() {
        return playerService.getPlayers();
    }

    @RequestMapping(value ="/create", method = RequestMethod.POST)
    public ResponseEntity createPlayer(@RequestBody PlayerDto playerDto) {
        return playerService.createPlayer(playerDto);


    }

    @RequestMapping(value ="/update", method = RequestMethod.PUT)
    public void updatelayer(@RequestBody PlayerDto playerDto) {
        playerService.updatePlayer(playerDto);
    }

    @RequestMapping(value ="/delete/{playerId}", method = RequestMethod.DELETE)
    public void deletePlayer(@PathVariable Integer playerId) {
        playerService.deletePlayer(playerId);
    }


    @RequestMapping("/getMatches/{playerId}")
    public List<PlayerMatch> getPlayerMatches(@PathVariable Integer playerId) {
        return playerMatchService.getPlayerMatches(playerId);
    }

    @RequestMapping("/getAllMatches")
    public List<PlayerMatch> getAllMatches() {
        return playerMatchService.getAllMatches();
    }


}
