package pl.engineerproject.pw.fifapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LeagueDto {

    private Integer leagueId;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String location;
    private Integer ownerId;
}
