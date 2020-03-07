package pl.engineerproject.pw.fifapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.engineerproject.pw.fifapp.converter.PlayerConverter;
import pl.engineerproject.pw.fifapp.dto.PlayerDto;
import pl.engineerproject.pw.fifapp.model.Player;
import pl.engineerproject.pw.fifapp.repository.MatchRepository;
import pl.engineerproject.pw.fifapp.repository.PlayerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public PlayerDto getPlayerById(Integer playerId) {
        return PlayerConverter.entityToDto(playerRepository.getOne(playerId));
    }

    @Override
    public List<PlayerDto> getPlayers() {
        return playerRepository.findAll().stream().map(PlayerConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity createPlayer(PlayerDto playerDto) {

        Player player = PlayerConverter.dtoToEntity(playerDto);
        playerRepository.save(PlayerConverter.dtoToEntity(playerDto));

        player.setPlayerId(player.getPlayerId());


        return ResponseEntity.ok("Player created: {"+player.getPlayerId()+"}");
    }

    @Override
    public void updatePlayer(PlayerDto playerDto) {
        playerRepository.save(PlayerConverter.dtoToEntity(playerDto));
    }

    @Override
    public void deletePlayer(Integer playerId) {
        playerRepository.deleteById(playerId);
    }



    //    void createPlayer(PlayerDto playerDto);
    //    void deletePlayer(PlayerDto playerDto);
    //    void updatePlauer(PlayerDto playerDto);
}
