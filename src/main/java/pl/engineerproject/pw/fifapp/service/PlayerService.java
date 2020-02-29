package pl.engineerproject.pw.fifapp.service;

import pl.engineerproject.pw.fifapp.dto.PlayerDto;

import java.util.List;

public interface PlayerService {
    PlayerDto getPlayerById(Integer playerId);
    List<PlayerDto> getPlayers();
    void createPlayer(PlayerDto playerDto);
    void deletePlayer(PlayerDto playerDto);
    void updatePlayer(PlayerDto playerDto);


}
