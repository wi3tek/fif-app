package pl.engineerproject.pw.fifapp.dto;

import lombok.*;
import pl.engineerproject.pw.fifapp.model.MatchData;
import pl.engineerproject.pw.fifapp.model.Round;
import pl.engineerproject.pw.fifapp.model.TeamType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamDto {

    private Integer teamId;
    private String name;
    private Integer overall;
    private String logoUrl;
    private TeamType teamType;
}
