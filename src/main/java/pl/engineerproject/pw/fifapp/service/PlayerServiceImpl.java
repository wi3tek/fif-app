package pl.engineerproject.pw.fifapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.engineerproject.pw.fifapp.mapper.PlayerMapper;
import pl.engineerproject.pw.fifapp.dto.PlayerDto;
import pl.engineerproject.pw.fifapp.model.Player;
import pl.engineerproject.pw.fifapp.repository.PlayerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public PlayerDto getPlayerById(Integer playerId) {
        return PlayerMapper.entityToDto(playerRepository.getOne(playerId));
    }

    @Override
    public List<PlayerDto> getPlayers() {
        return playerRepository.findAll().stream().map( PlayerMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity createPlayer(PlayerDto playerDto) {

        Player player = PlayerMapper.dtoToEntity(playerDto);
        playerRepository.save( PlayerMapper.dtoToEntity(playerDto));

        player.setPlayerId(player.getPlayerId());


        return ResponseEntity.ok("{\"Player created\":"+player.getPlayerId()+"}");
    }

    @Override
    public void updatePlayer(PlayerDto playerDto) {
        playerRepository.save( PlayerMapper.dtoToEntity(playerDto));
    }

    @Override
    public void deletePlayer(Integer playerId) {
        playerRepository.deleteById(playerId);
    }



    //    void createPlayer(PlayerDto playerDto);
    //    void deletePlayer(PlayerDto playerDto);
    //    void updatePlauer(PlayerDto playerDto);
}
