package pl.engineerproject.pw.fifapp.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.engineerproject.pw.fifapp.model.helper.LeagueTable;
import pl.engineerproject.pw.fifapp.model.helper.PlayerMatch;
import pl.engineerproject.pw.fifapp.repository.helper.PlayerMatchRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerMatchServiceImpl implements PlayerMatchService{

    @Autowired
    PlayerMatchRepository playerMatchRepository;


    @Override
    public List<PlayerMatch> getPlayerMatches(Integer playerId) {
        List<PlayerMatch>  playerMatches = playerMatchRepository.findAll(Sort.by(Sort.Direction.DESC,"matchDate"));
        List<PlayerMatch>  playerMatchesResult = new ArrayList<>();

        for (PlayerMatch playerMatch : playerMatches) {
            if (playerMatch.getPlayerId().equals(playerId)) {
                playerMatchesResult.add(playerMatch);
            }
        }
        return playerMatchesResult;
    }


    @Override
    public List<PlayerMatch> getAllMatches() {
        return playerMatchRepository.findAll(Sort.by(Sort.Direction.DESC,"matchDate"));
    }

    @Override
    public List<PlayerMatch> getPlayersMatchesInLeague(Integer leagueId) {
        List<PlayerMatch>  playerMatches = playerMatchRepository.findAll(Sort.by(Sort.Direction.DESC,"matchDate"));
        List<PlayerMatch>  playerMatchesResult = new ArrayList<>();

        for (PlayerMatch playerMatch : playerMatches) {
            if (playerMatch.getLeagueId().equals(leagueId)) {
                playerMatchesResult.add(playerMatch);
            }
        }
        return playerMatchesResult;
    }
}
