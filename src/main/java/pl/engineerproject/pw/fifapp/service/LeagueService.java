package pl.engineerproject.pw.fifapp.service;

import pl.engineerproject.pw.fifapp.dto.LeagueDto;

import java.util.List;

public interface LeagueService {
    LeagueDto getLeagueById(Integer leagueId);
    void saveLeague(LeagueDto leagueDto);
    List<LeagueDto> getAllLeagues();

}
