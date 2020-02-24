package pl.engineerproject.pw.fifapp.converter;

import pl.engineerproject.pw.fifapp.dto.LeagueDto;
import pl.engineerproject.pw.fifapp.model.League;

import java.util.stream.Collectors;

public class LeagueConverter {

    public static League dtoToEntity(LeagueDto leagueDto) {
        League league = new League(leagueDto.getName(),leagueDto.getDescription(),leagueDto.getStartDate(),leagueDto.getEndDate(), leagueDto.getLocation(),null);
        league.setLeagueId(leagueDto.getLeagueId());
        league.setRounds(leagueDto.getRoundDtos().stream().map(RoundConverter::dtoToEntity).collect(Collectors.toList()));

        return league;
    }

    public static LeagueDto entityToDto(League league) {
        LeagueDto leagueDto = new LeagueDto(league.getLeagueId(),league.getName(),league.getDescription(),league.getStartDate(),league.getEndDate(),league.getLocation(),null);
        leagueDto.setRoundDtos(league.getRounds().stream().map(RoundConverter::entityToDto).collect(Collectors.toList()));


        return leagueDto;
    }

}
