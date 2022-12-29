package pl.engineerproject.pw.fifapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PlayerDto {

    private Integer playerId;
    private String name;
    private String alias;
    private Date joinDate;
    private Date lastModificationDate;
    private Integer ownerId;
    private String userName;


    public PlayerDto(Integer playerId, String name, String alias, Date joinDate,
                     Date lastModificationDate) {
        this.playerId = playerId;
        this.name = name;
        this.alias = alias;
        this.joinDate = joinDate;
        this.lastModificationDate = lastModificationDate;
    }
}
