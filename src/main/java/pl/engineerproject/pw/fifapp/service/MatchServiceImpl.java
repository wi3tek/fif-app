package pl.engineerproject.pw.fifapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.engineerproject.pw.fifapp.mapper.MatchMapper;
import pl.engineerproject.pw.fifapp.dto.MatchDto;
import pl.engineerproject.pw.fifapp.model.MatchData;
import pl.engineerproject.pw.fifapp.repository.MatchRepository;
import pl.engineerproject.pw.fifapp.service.helper.MatchPlayerRelService;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MatchServiceImpl implements MatchService {

    @Autowired
    MatchRepository matchRepository;


    @Override
    public void addMatch(MatchDto matchDto) {
        matchRepository.save( MatchMapper.dtoToEntity(matchDto));
    }

    @Autowired
    MatchPlayerRelService matchPlayerRelService;

    @Override
    public MatchDto getMatchById(Integer matchId) {
        return MatchMapper.entityToDto(matchRepository.getOne(matchId));
    }


    @Override
    public void editMatch(MatchDto matchDto) {
        matchRepository.save( MatchMapper.dtoToEntity(matchDto));
    }

    @Override
    public List<MatchDto> getAllMatches() {

        return matchRepository.findAll(Sort.by(Sort.Direction.DESC,"matchDate")).stream().map( MatchMapper::entityToDto).collect(Collectors.toList());
    }


    @Override
    public List<MatchDto> getRoundMatches(Integer roundId) {
        List<MatchDto> roundMatches = matchRepository.findAll(Sort.by(Sort.Direction.DESC,"matchDate")).stream().map( MatchMapper::entityToDto).collect(Collectors.toList());
        List<MatchDto> result = new ArrayList<>();

        for (MatchDto roundMatch : roundMatches) {

            try {
                if (roundMatch.getRoundId().equals(roundId)) {
                    result.add(roundMatch);
                }
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }
        return result;

    }

    @Override
    public void deleteMatch(Integer matchId)  {
        MatchData matchData =  matchRepository.getOne(matchId);

        String homeFirstPlayerRelId = matchData.getMatchId() +"_"+matchData.getHomeFirstPlayer().getPlayerId();
        String homeSecondPlayerRelId = matchData.getMatchId() +"_"+matchData.getHomeSecondPlayer().getPlayerId();
        String awayFirstPlayerRelId = matchData.getMatchId() +"_"+matchData.getAwayFirstPlayer().getPlayerId();
        String awaySecondPlayerRelId = matchData.getMatchId() +"_"+matchData.getAwaySecondPlayer().getPlayerId();

        matchPlayerRelService.deleteMatchPlayerRel(homeFirstPlayerRelId);
        matchPlayerRelService.deleteMatchPlayerRel(homeSecondPlayerRelId);
        matchPlayerRelService.deleteMatchPlayerRel(awayFirstPlayerRelId);
        matchPlayerRelService.deleteMatchPlayerRel(awaySecondPlayerRelId);

        matchRepository.deleteById(matchId);
    }

    @Override
    public List<MatchDto> getLeagueMatches(Integer leagueId) {
            List<MatchDto> leagueMatches = matchRepository.findAll(Sort.by(Sort.Direction.DESC,"matchDate")).stream().map( MatchMapper::entityToDto).collect(Collectors.toList());
        List<MatchDto> result = new ArrayList<>();

        for (MatchDto match : leagueMatches) {

            try {
                if (match.getLeagueId().equals(leagueId)) {
                    result.add(match);
                }
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }
        return result;
    }

    @Override
    public ResponseEntity createMatch(MatchDto matchDto) {

        if(matchDto==null) {
            throw new ResourceNotFoundException("Empty object matchDto");
        } else {
            MatchData matchData = MatchMapper.dtoToEntity(matchDto);
            matchRepository.save(matchData);

            matchData.setMatchId(matchData.getMatchId());
            matchPlayerRelService.insertMatchPlayerRel(matchData);

            return ResponseEntity.ok("{\"Created match\":"+matchData.getMatchId()+"}");
        }
    }
}
