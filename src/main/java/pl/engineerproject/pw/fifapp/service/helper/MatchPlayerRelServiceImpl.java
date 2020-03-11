package pl.engineerproject.pw.fifapp.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.engineerproject.pw.fifapp.dto.MatchDto;
import pl.engineerproject.pw.fifapp.model.MatchData;
import pl.engineerproject.pw.fifapp.model.helper.MatchPlayerRel;
import pl.engineerproject.pw.fifapp.repository.helper.MatchPlayerRelRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class MatchPlayerRelServiceImpl implements MatchPlayerRelService {

    @Autowired
    MatchPlayerRelRepository matchPlayerRelRepository;

    @Override
    public MatchPlayerRel getMatchPlayerRelById(String matchPlayerRelId) {
        return matchPlayerRelRepository.getOne(matchPlayerRelId);
    }

    @Override
    public void deleteMatchPlayerRel(String matchDataId) {
        matchPlayerRelRepository.deleteById(matchDataId);
    }

    @Override
    public void updateMatchPlayerRel(MatchData matchData) {
        Integer matchId = matchData.getMatchId();
        Integer homeFirstPlayerId = matchData.getHomeFirstPlayer().getPlayerId();
        Integer homeSecondPlayerId = matchData.getHomeSecondPlayer().getPlayerId();
        Integer awayFirstPlayerId = matchData.getAwayFirstPlayer().getPlayerId();
        Integer awaySecondPlayerId = matchData.getAwaySecondPlayer().getPlayerId();
        Integer homeGoals = matchData.getHomeGoals();
        Integer awayGoals = matchData.getAwayGoals();
        LocalDateTime updateDate = matchData.getUpdateDate();

        MatchPlayerRel matchPlayerRelFirst = new MatchPlayerRel(setMatchPlayerRelId(homeFirstPlayerId,matchId), homeFirstPlayerId,calculatePoints(homeGoals,awayGoals),homeGoals,awayGoals,calculateWinFlag(homeGoals,awayGoals),calculateDrawFlag(homeGoals,awayGoals),calculateLoseFlag(homeGoals,awayGoals),calculateGoalsDiff(homeGoals,awayGoals),updateDate,"H1",matchId);

        MatchPlayerRel matchPlayerRelSecond =  new MatchPlayerRel(setMatchPlayerRelId(homeSecondPlayerId,matchId),homeSecondPlayerId,calculatePoints(homeGoals,awayGoals),homeGoals,awayGoals,calculateWinFlag(homeGoals,awayGoals),calculateDrawFlag(homeGoals,awayGoals),calculateLoseFlag(homeGoals,awayGoals),calculateGoalsDiff(homeGoals,awayGoals),updateDate,"H2",matchId);

        MatchPlayerRel matchPlayerRelThird = new MatchPlayerRel(setMatchPlayerRelId(awayFirstPlayerId,matchId),awayFirstPlayerId,calculatePoints(awayGoals,homeGoals),awayGoals,homeGoals,calculateWinFlag(awayGoals,homeGoals),calculateDrawFlag(awayGoals,homeGoals),calculateLoseFlag(awayGoals,homeGoals),calculateGoalsDiff(awayGoals,homeGoals),updateDate,"A1",matchId);

        MatchPlayerRel matchPlayerRelFourth = new MatchPlayerRel(setMatchPlayerRelId(awaySecondPlayerId,matchId),awaySecondPlayerId,calculatePoints(awayGoals,homeGoals),awayGoals,homeGoals,calculateWinFlag(awayGoals,homeGoals),calculateDrawFlag(awayGoals,homeGoals),calculateLoseFlag(awayGoals,homeGoals),calculateGoalsDiff(awayGoals,homeGoals),updateDate,"A2",matchId);


        matchPlayerRelRepository.save(matchPlayerRelFirst);
        matchPlayerRelRepository.save(matchPlayerRelSecond);
        matchPlayerRelRepository.save(matchPlayerRelThird);
        matchPlayerRelRepository.save(matchPlayerRelFourth);


    }

    @Override
    public void insertMatchPlayerRel(MatchData matchData) {

        Integer matchId = matchData.getMatchId();
        Integer homeFirstPlayerId = matchData.getHomeFirstPlayer().getPlayerId();
        Integer homeSecondPlayerId = matchData.getHomeSecondPlayer().getPlayerId();
        Integer awayFirstPlayerId = matchData.getAwayFirstPlayer().getPlayerId();
        Integer awaySecondPlayerId = matchData.getAwaySecondPlayer().getPlayerId();
        Integer homeGoals = matchData.getHomeGoals();
        Integer awayGoals = matchData.getAwayGoals();
        LocalDateTime updateDate = matchData.getUpdateDate();

        MatchPlayerRel matchPlayerRelFirst = new MatchPlayerRel(setMatchPlayerRelId(homeFirstPlayerId,matchId), homeFirstPlayerId,calculatePoints(homeGoals,awayGoals),homeGoals,awayGoals,calculateWinFlag(homeGoals,awayGoals),calculateDrawFlag(homeGoals,awayGoals),calculateLoseFlag(homeGoals,awayGoals),calculateGoalsDiff(homeGoals,awayGoals),updateDate,"H1",matchId);

        MatchPlayerRel matchPlayerRelSecond =  new MatchPlayerRel(setMatchPlayerRelId(homeSecondPlayerId,matchId),homeSecondPlayerId,calculatePoints(homeGoals,awayGoals),homeGoals,awayGoals,calculateWinFlag(homeGoals,awayGoals),calculateDrawFlag(homeGoals,awayGoals),calculateLoseFlag(homeGoals,awayGoals),calculateGoalsDiff(homeGoals,awayGoals),updateDate,"H2",matchId);

        MatchPlayerRel matchPlayerRelThird = new MatchPlayerRel(setMatchPlayerRelId(awayFirstPlayerId,matchId),awayFirstPlayerId,calculatePoints(awayGoals,homeGoals),awayGoals,homeGoals,calculateWinFlag(awayGoals,homeGoals),calculateDrawFlag(awayGoals,homeGoals),calculateLoseFlag(awayGoals,homeGoals),calculateGoalsDiff(awayGoals,homeGoals),updateDate,"A1",matchId);

        MatchPlayerRel matchPlayerRelFourth = new MatchPlayerRel(setMatchPlayerRelId(awaySecondPlayerId,matchId),awaySecondPlayerId,calculatePoints(awayGoals,homeGoals),awayGoals,homeGoals,calculateWinFlag(awayGoals,homeGoals),calculateDrawFlag(awayGoals,homeGoals),calculateLoseFlag(awayGoals,homeGoals),calculateGoalsDiff(awayGoals,homeGoals),updateDate,"A2",matchId);


        matchPlayerRelRepository.save(matchPlayerRelFirst);
        matchPlayerRelRepository.save(matchPlayerRelSecond);
        matchPlayerRelRepository.save(matchPlayerRelThird);
        matchPlayerRelRepository.save(matchPlayerRelFourth);


    }


    private Integer calculatePoints(Integer goalsScored, Integer goalsConceded) {

        int result = -2; // simply to check if errors

        if(goalsScored>goalsConceded)
            result= 3;
        else if(goalsScored<goalsConceded)
            result= 0;
        else if(goalsScored==goalsConceded)
            result= 1;

        return result;
    }

    private Integer calculateWinFlag(Integer goalsScored, Integer goalsConceded) {
        return (goalsScored>goalsConceded) ? 1:0;
    }

    private Integer calculateDrawFlag(Integer goalsScored, Integer goalsConceded) {
        return (goalsScored==goalsConceded) ? 1:0;
    }

    private Integer calculateLoseFlag(Integer goalsScored, Integer goalsConceded) {
        return (goalsScored<goalsConceded) ? 1:0;
    }

    private Integer calculateGoalsDiff(Integer goalsScored, Integer goalsConceded) {
        return goalsScored-goalsConceded;
    }

    private String setMatchPlayerRelId(Integer playerId, Integer matchId) {
        return matchId +"_" + playerId;
    }

}
