package pl.engineerproject.pw.fifapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.engineerproject.pw.fifapp.converter.PlayerConverter;
import pl.engineerproject.pw.fifapp.dto.PlayerDto;
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
    public void createPlayer(PlayerDto playerDto) {
        playerRepository.save(PlayerConverter.dtoToEntity(playerDto));
    }

    @Override
    public void updatePlayer(PlayerDto playerDto) {
        playerRepository.save(PlayerConverter.dtoToEntity(playerDto));
    }

    @Override
    public void deletePlayer(PlayerDto playerDto) {
        playerRepository.delete(PlayerConverter.dtoToEntity(playerDto));
    }



    //    void createPlayer(PlayerDto playerDto);
    //    void deletePlayer(PlayerDto playerDto);
    //    void updatePlauer(PlayerDto playerDto);
}