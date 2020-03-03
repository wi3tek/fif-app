package pl.engineerproject.pw.fifapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.engineerproject.pw.fifapp.converter.MatchConverter;
import pl.engineerproject.pw.fifapp.dto.MatchDto;
import pl.engineerproject.pw.fifapp.repository.MatchRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    MatchRepository matchRepository;

    @Override
    public MatchDto getMatchById(Integer matchId) {
        return MatchConverter.entityToDto(matchRepository.getOne(matchId));
    }

    @Override
    public void addMatch(MatchDto matchDto) {
        matchRepository.save(MatchConverter.dtoToEntity(matchDto));
    }

    @Override
    public void editMatch(MatchDto matchDto) {
        matchRepository.save(MatchConverter.dtoToEntity(matchDto));
    }

    @Override
    public List<MatchDto> getAllMatches() {

        return matchRepository.findAll().stream().map(MatchConverter::entityToDto).collect(Collectors.toList());
    }


    @Override
    public List<MatchDto> getRoundMatches(Integer roundId) {
        List<MatchDto> roundMatches = matchRepository.findAll().stream().map(MatchConverter::entityToDto).collect(Collectors.toList());
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
    public void deleteMatch(MatchDto matchDto) {
        matchRepository.delete(MatchConverter.dtoToEntity(matchDto));
    }

    @Override
    public List<MatchDto> getLeagueMatches(Integer leagueId) {
        List<MatchDto> leagueMatches = matchRepository.findAll().stream().map(MatchConverter::entityToDto).collect(Collectors.toList());
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
}
