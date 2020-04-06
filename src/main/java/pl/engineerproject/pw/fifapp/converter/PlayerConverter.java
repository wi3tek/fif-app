package pl.engineerproject.pw.fifapp.converter;

import pl.engineerproject.pw.fifapp.dto.PlayerDto;
import pl.engineerproject.pw.fifapp.model.Player;
import pl.engineerproject.pw.fifapp.model.User;

public class PlayerConverter {

    public static Player dtoToEntity(PlayerDto playerDto) {

        Player player = new Player(playerDto.getName(),playerDto.getAlias(),playerDto.getDateOfBirth(),playerDto.getJoinDate(),playerDto.getLastModificationDate());
        player.setPlayerId(playerDto.getPlayerId());

        if(playerDto.getOwnerId()!=null) {
            player.setOwner(new User());
            player.getOwner().setId(playerDto.getOwnerId());
            player.getOwner().setUsername(playerDto.getUserName());
        }
        return player;
    }

    public static PlayerDto entityToDto(Player player) {
        PlayerDto playerDto = new PlayerDto(player.getPlayerId(),player.getName(), player.getAlias(),player.getDateOfBirth(),player.getJoinDate(),player.getLastModificationDate());

        if(player.getOwner()!=null) {
            playerDto.setOwnerId(player.getOwner().getId());
            playerDto.setUserName(player.getOwner().getUsername());
        }
        return playerDto;
    }
}
