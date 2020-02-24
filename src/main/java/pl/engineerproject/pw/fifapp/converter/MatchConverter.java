package pl.engineerproject.pw.fifapp.converter;

import org.springframework.beans.BeanUtils;
import pl.engineerproject.pw.fifapp.dto.MatchDto;
import pl.engineerproject.pw.fifapp.model.MatchData;

public class MatchConverter {

    public static MatchData dtoToEntity(MatchDto matchDto) {

        MatchData match = new MatchData(matchDto.getMatchDate(),null,null,null,null,matchDto.getHomeGoals(),matchDto.getAwayGoals(),null,null,matchDto.getComment(),matchDto.getUpdateDate(),matchDto.getMatchType(),null);
        match.setMatchId(matchDto.getMatchId());



        return match;
    }
}
