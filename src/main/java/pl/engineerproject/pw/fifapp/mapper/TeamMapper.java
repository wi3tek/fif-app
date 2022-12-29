package pl.engineerproject.pw.fifapp.mapper;

import pl.engineerproject.pw.fifapp.dto.TeamDto;
import pl.engineerproject.pw.fifapp.model.Team;

public class TeamMapper {

    public static Team dtoToEntity(TeamDto teamDto) {
        Team team = new Team(teamDto.getName(),teamDto.getOverall(),teamDto.getLogoUrl(),teamDto.getTeamType());
        team.setTeamId(teamDto.getTeamId());

        return team;

    }

    public static TeamDto entityToDto(Team team) {
        return new TeamDto(team.getTeamId(),team.getName(),team.getOverallRating(),team.getLogoUrl(),
                team.getTeamType());
    }
}
