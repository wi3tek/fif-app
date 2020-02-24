package pl.engineerproject.pw.fifapp.converter;

import pl.engineerproject.pw.fifapp.dto.RoundDto;
import pl.engineerproject.pw.fifapp.dto.TeamDto;
import pl.engineerproject.pw.fifapp.model.Round;
import pl.engineerproject.pw.fifapp.model.Team;

import java.util.stream.Collectors;

public class TeamConverter {

    public static Team dtoToEntity(TeamDto teamDto) {
        Team team = new Team(teamDto.getName(),teamDto.getOverall(),teamDto.getLogoUrl(),null);
        team.setTeamId(teamDto.getTeamId());
        team.setMatches(teamDto.getMatchDtos().stream().map(MatchConverter::dtoToEntity).collect(Collectors.toList()));
        return team;

    }
}
