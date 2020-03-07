package pl.engineerproject.pw.fifapp.service.helper;

        import pl.engineerproject.pw.fifapp.dto.MatchDto;
        import pl.engineerproject.pw.fifapp.model.MatchData;
        import pl.engineerproject.pw.fifapp.model.helper.MatchPlayerRel;

public interface MatchPlayerRelService {
    MatchPlayerRel getMatchPlayerRelById(String matchPlayerRelId);
    void insertMatchPlayerRel(MatchData matchData);
    void updateMatchPlayerRel(MatchData matchData);

    void deleteMatchPlayerRel(String MatchDataId);
}
