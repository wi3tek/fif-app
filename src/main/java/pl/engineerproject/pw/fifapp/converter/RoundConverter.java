package pl.engineerproject.pw.fifapp.converter;

import pl.engineerproject.pw.fifapp.dto.RoundDto;
import pl.engineerproject.pw.fifapp.model.Round;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RoundConverter {

    public static Round dtoToEntity(RoundDto roundDto) {
        Round round = new Round(roundDto.getRoundDate(),roundDto.getWhichLeagueRound(),roundDto.getDescription(),null,null,null);
        round.setRoundId(roundDto.getRoundId());

        round.setMatches(roundDto.getMatchDtos().stream().map(MatchConverter::dtoToEntity).collect(Collectors.toList()));
        round.setLeague(roundDto.getLeagueDto().stream().map(LeagueConverter::dtoToEntity).collect(Collectors.toList()));
        round.setTeams(roundDto.getTeamDtos().stream().map(TeamConverter::dtoToEntity).collect(Collectors.toList()));


        return round;
    }

    public static RoundDto entityToDto(Round round) {
        RoundDto roundDto = new RoundDto(round.getRoundId(),round.getRoundDate(),round.getWhichLeagueRound(),round.getDescription(),null,null,null);
       // roundDto.setMatchDtos(round.getMatches().stream().map(MatchConverter::entityToDto).collect(Collectors.toList()));


        return roundDto;
    }
}
