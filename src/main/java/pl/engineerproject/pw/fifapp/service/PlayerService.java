package pl.engineerproject.pw.fifapp.service;

import org.springframework.http.ResponseEntity;
import pl.engineerproject.pw.fifapp.dto.PlayerDto;

import java.util.List;

public interface PlayerService {
    PlayerDto getPlayerById(Integer playerId);
    List<PlayerDto> getPlayers();
    ResponseEntity createPlayer(PlayerDto playerDto);
    void deletePlayer(Integer playerId);
    void updatePlayer(PlayerDto playerDto);


}
