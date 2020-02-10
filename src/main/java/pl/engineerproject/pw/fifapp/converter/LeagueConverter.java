package pl.engineerproject.pw.fifapp.converter;

import pl.engineerproject.pw.fifapp.dto.LeagueDto;
import pl.engineerproject.pw.fifapp.model.League;

public class LeagueConverter {

    public static League dtoToEntity(LeagueDto leagueDto) {
        League league = new League(leagueDto.getName(),leagueDto.getDescription(),leagueDto.getStartDate(),leagueDto.getEndDate(), leagueDto.getLocation());
        league.setLeagueId(leagueDto.getLeagueId());

        return league;
    }

    public static LeagueDto entityToDto(League league) {
        LeagueDto leagueDto = new LeagueDto(league.getLeagueId(),league.getName(),league.getDescription(),league.getStartDate(),league.getEndDate(),league.getLocation());

        return leagueDto;
    }

}
