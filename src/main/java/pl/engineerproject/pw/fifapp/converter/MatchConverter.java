package pl.engineerproject.pw.fifapp.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import pl.engineerproject.pw.fifapp.dto.MatchDto;
import pl.engineerproject.pw.fifapp.model.*;

import java.util.stream.Collectors;

public class MatchConverter {

    public static MatchData dtoToEntity(MatchDto matchDto) {

        Player homeFirstPlayer = new Player();
        homeFirstPlayer.setPlayerId(matchDto.getHomeFirstPlayerId());
        homeFirstPlayer.setName(matchDto.getHomeFirstPlayerAlias());

        Player homeSecondPlayer = new Player();
        homeSecondPlayer.setPlayerId(matchDto.getHomeSecondPlayerId());
        homeSecondPlayer.setName(matchDto.getHomeSecondPlayerAlias());

        Player awayFirstPlayer = new Player();
        awayFirstPlayer.setPlayerId(matchDto.getAwayFirstPlayerId());
        awayFirstPlayer.setName(matchDto.getAwayFirstPlayerAlias());

        Player awaySecondPlayer = new Player();
        awaySecondPlayer.setPlayerId(matchDto.getAwaySecondPlayerId());
        awaySecondPlayer.setName(matchDto.getAwaySecondPlayerAlias());

        Team homeTeam = new Team();
        homeTeam.setTeamId(matchDto.getHomeTeamId());
        homeTeam.setName(matchDto.getHomeTeamName());

        Team awayTeam = new Team();
        awayTeam.setTeamId(matchDto.getAwayTeamId());
        awayTeam.setName(matchDto.getAwayTeamName());

        Round round = new Round();
        round.setRoundId(matchDto.getRoundId());

        League league = new League();
        league.setLeagueId(matchDto.getLeagueId());

        MatchData matchData = new MatchData(matchDto.getMatchDate(),homeFirstPlayer,homeSecondPlayer,awayFirstPlayer,awaySecondPlayer,matchDto.getHomeGoals(),matchDto.getAwayGoals(),homeTeam,awayTeam,matchDto.getComment(),matchDto.getUpdateDate(),matchDto.getMatchType());
        matchData.setMatchId(matchDto.getMatchId());

        matchData.setRound(round);
        matchData.setLeague(league);

        return matchData;
    }

    public static MatchDto entityToDto(MatchData match) {

        MatchDto matchDto = new MatchDto(match.getMatchId(),match.getMatchDate(),match.getHomeGoals(),match.getAwayGoals(),match.getComment(),match.getUpdateDate(),match.getMatchType());

        matchDto.setHomeFirstPlayerId(match.getHomeFirstPlayer().getPlayerId());
        matchDto.setHomeFirstPlayerAlias(match.getHomeFirstPlayer().getAlias());

        matchDto.setHomeSecondPlayerId(match.getHomeSecondPlayer().getPlayerId());
        matchDto.setHomeSecondPlayerAlias(match.getHomeSecondPlayer().getAlias());

        matchDto.setAwayFirstPlayerId(match.getAwayFirstPlayer().getPlayerId());
        matchDto.setAwayFirstPlayerAlias(match.getAwayFirstPlayer().getAlias());

        matchDto.setAwaySecondPlayerId(match.getAwaySecondPlayer().getPlayerId());
        matchDto.setAwaySecondPlayerAlias(match.getAwaySecondPlayer().getAlias());

        matchDto.setHomeTeamId(match.getHomeTeam().getTeamId());
        matchDto.setHomeTeamName(match.getHomeTeam().getName());
        matchDto.setHomeTeamLogoUrl(match.getHomeTeam().getLogoUrl());

        matchDto.setAwayTeamId(match.getAwayTeam().getTeamId());
        matchDto.setAwayTeamName(match.getAwayTeam().getName());
        matchDto.setAwayTeamLogoUrl(match.getAwayTeam().getLogoUrl());

        matchDto.setRoundId(match.getRound().getRoundId());
        matchDto.setLeagueId(match.getLeague().getLeagueId());


        return matchDto;
    }
}
