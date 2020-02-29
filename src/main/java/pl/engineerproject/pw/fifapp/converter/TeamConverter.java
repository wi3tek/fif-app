package pl.engineerproject.pw.fifapp.converter;

import org.modelmapper.ModelMapper;
import pl.engineerproject.pw.fifapp.dto.RoundDto;
import pl.engineerproject.pw.fifapp.dto.TeamDto;
import pl.engineerproject.pw.fifapp.model.Round;
import pl.engineerproject.pw.fifapp.model.Team;

import java.util.stream.Collectors;

public class TeamConverter {

    public static Team dtoToEntity(TeamDto teamDto) {
        Team team = new Team(teamDto.getName(),teamDto.getOverall(),teamDto.getLogoUrl());
        team.setTeamId(teamDto.getTeamId());

        return team;

    }

    public static TeamDto entityToDto(Team team) {
        return new TeamDto(team.getTeamId(),team.getName(),team.getOverallRating(),team.getLogoUrl());
    }
}
