package pl.engineerproject.pw.fifapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.engineerproject.pw.fifapp.converter.RoundConverter;
import pl.engineerproject.pw.fifapp.dto.RoundDto;
import pl.engineerproject.pw.fifapp.repository.RoundRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoundServiceImpl implements RoundService {

    @Autowired
    RoundRepository roundRepository;

    @Override
    public RoundDto getRoundById(Integer roundId) {
        return RoundConverter.entityToDto(roundRepository.getOne(roundId));
    }

    @Override
    public void saveRound(RoundDto roundDto) {
        roundRepository.save(RoundConverter.dtoToEntity(roundDto));
    }

    @Override
    public List<RoundDto> getAllRounds() {
        return roundRepository.findAll(Sort.by(Sort.Direction.DESC,"roundDate")).stream().map(RoundConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    public List<RoundDto> getLeagueRounds(Integer leagueId) {
        List<RoundDto> leagueRounds = roundRepository.findAll(Sort.by(Sort.Direction.DESC,"roundDate")).stream().map(RoundConverter::entityToDto).collect(Collectors.toList());
        List<RoundDto> result = new ArrayList<>();

        for (RoundDto leagueRound : leagueRounds) {

            try {
                if (leagueRound.getLeagueId().equals(leagueId)) {
                    result.add(leagueRound);
                }
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }


        return result;
    }

    @Override
    public void deleteRoundById(Integer roundId) {
        roundRepository.deleteById(roundId);
    }
}
