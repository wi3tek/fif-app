package pl.engineerproject.pw.fifapp.service;

import pl.engineerproject.pw.fifapp.dto.RoundDto;

import java.util.List;

public interface RoundService {

    RoundDto getRoundById(Integer roundId);
    void saveRound(RoundDto roundDto);
    List<RoundDto> getAllRounds();
    List<RoundDto> getLeagueRounds(Integer leagueId);
}
