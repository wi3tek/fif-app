package pl.engineerproject.pw.fifapp.mapper;

import org.modelmapper.ModelMapper;
import pl.engineerproject.pw.fifapp.dto.RoundDto;
import pl.engineerproject.pw.fifapp.model.League;
import pl.engineerproject.pw.fifapp.model.Round;
import java.util.stream.Collectors;

public class RoundMapper {

    public static Round dtoToEntity(RoundDto roundDto) {
        League league = new League(roundDto.getLeagueName(),roundDto.getDescription(),roundDto.getLeagueStartDate(),roundDto.getLeagueEndDate(),roundDto.getLeagueLocation(),null);
        league.setLeagueId(roundDto.getLeagueId());

        Round round = new Round(
                roundDto.getRoundDate()
                ,roundDto.getWhichLeagueRound()
                ,roundDto.getDescription()
                ,league
                ,null
                ,null);

        round.setRoundId(roundDto.getRoundId());
        return round;
    }

    public static RoundDto entityToDto(Round round) {
        ModelMapper modelMapper = new ModelMapper();

        RoundDto roundDto =  modelMapper.map(round,RoundDto.class);

        try {
            roundDto.setLeagueId(round.getLeague().getLeagueId());
            roundDto.setLeagueName(round.getLeague().getName());
            roundDto.setLeagueDescription(round.getLeague().getDescription());
            roundDto.setLeagueLocation(round.getLeague().getLocation());
            roundDto.setLeagueStartDate(round.getLeague().getStartDate());
            roundDto.setLeagueEndDate(round.getLeague().getEndDate());
            roundDto.setMatchDtos(round.getMatches().stream().map( MatchMapper::entityToDto).collect(Collectors.toList()));
            roundDto.setTeamDtos(round.getTeams().stream().map( TeamMapper::entityToDto).collect(Collectors.toList()));
        } catch(NullPointerException e) {
            System.out.println(e);
        }


        return roundDto;
    }
}
