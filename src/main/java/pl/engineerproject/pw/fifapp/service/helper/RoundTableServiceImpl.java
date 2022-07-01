package pl.engineerproject.pw.fifapp.service.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.engineerproject.pw.fifapp.model.Round;
import pl.engineerproject.pw.fifapp.model.helper.RoundResult;
import pl.engineerproject.pw.fifapp.repository.RoundRepository;
import pl.engineerproject.pw.fifapp.repository.helper.RoundsResultsRepository;

import java.util.ArrayList;
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

        List<Round> storedRounds = roundRepository.findAll();
        List<Integer> roundsInLeague = new ArrayList<>();
        List<RoundResult> storedRoundResults = roundsResultsRepository.findAll();

        storedRounds.stream()
                .filter(round -> round.getLeague().getLeagueId().equals( leagueId ))
                .forEach( round -> roundsInLeague.add(round.getRoundId()));


        List<RoundResult> finalRoundResult = new ArrayList<>();


        for (int i = 0; i <roundsInLeague.size() ; i++) {

            for (int j = 0; j <storedRoundResults.size() ; j++) {

                if(storedRoundResults.get(j).getRoundId().equals( roundsInLeague.get( i ) ))
                    finalRoundResult.add( storedRoundResults.get(j) );
            }

        }
        return finalRoundResult.stream()
                .sorted( Comparator.comparingDouble(RoundResult::getPointsRate)
                .reversed())
                .collect( Collectors.toList());

    }
}
