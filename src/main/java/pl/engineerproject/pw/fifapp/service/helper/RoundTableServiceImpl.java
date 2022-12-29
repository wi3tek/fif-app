package pl.engineerproject.pw.fifapp.service.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.engineerproject.pw.fifapp.model.Round;
import pl.engineerproject.pw.fifapp.model.helper.RoundResult;
import pl.engineerproject.pw.fifapp.repository.RoundRepository;
import pl.engineerproject.pw.fifapp.repository.helper.RoundsResultsRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RoundTableServiceImpl implements RoundTableService{
    private final RoundRepository roundRepository;

    private final RoundsResultsRepository roundsResultsRepository;

    @Override
    public List<RoundResult> roundTable(Integer leagueId) {
        List<RoundResult> storedRoundResults = roundsResultsRepository.findByRoundIds(generateRoundIds(leagueId));
        return storedRoundResults.stream()
                .sorted( Comparator.comparingDouble(RoundResult::getPointsRate)
                .reversed())
                .collect( Collectors.toList());

    }
    private List<Integer> generateRoundIds(Integer leagueId) {
        List<Round> storedRounds = roundRepository.findByLeagueId(leagueId);
        List<Integer> integers = storedRounds.stream().map(Round::getRoundId).toList();

        System.out.println("ROUND ID "+ integers);
        return integers;

    }
}
