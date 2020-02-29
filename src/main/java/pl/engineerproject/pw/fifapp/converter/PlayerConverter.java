package pl.engineerproject.pw.fifapp.converter;

import org.modelmapper.ModelMapper;
import pl.engineerproject.pw.fifapp.dto.PlayerDto;
import pl.engineerproject.pw.fifapp.model.Player;
import pl.engineerproject.pw.fifapp.model.User;

import java.util.stream.Collectors;

public class PlayerConverter {

    public static Player dtoToEntity(PlayerDto playerDto) {

        Player player = new Player(playerDto.getName(),playerDto.getAlias(),playerDto.getDateOfBirth(),playerDto.getJoinDate(),playerDto.getLastModificationDate());
        player.setPlayerId(playerDto.getPlayerId());

        if(playerDto.getUserId()!=null) {
            player.setUser(new User());
            player.getUser().setId(playerDto.getUserId());
            player.getUser().setUsername(playerDto.getUserName());
        }
        return player;
    }

    public static PlayerDto entityToDto(Player player) {
        PlayerDto playerDto = new PlayerDto(player.getPlayerId(),player.getName(), player.getAlias(),player.getDateOfBirth(),player.getJoinDate(),player.getLastModificationDate());

        if(player.getUser()!=null) {
            playerDto.setUserId(player.getUser().getId());
            playerDto.setUserName(player.getUser().getUsername());
        }
        return playerDto;
    }
}
