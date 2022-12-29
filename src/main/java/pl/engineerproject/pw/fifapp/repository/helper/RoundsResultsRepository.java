package pl.engineerproject.pw.fifapp.repository.helper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.engineerproject.pw.fifapp.model.helper.RoundResult;
import java.util.List;

@Repository
public interface RoundsResultsRepository extends JpaRepository<RoundResult,String> {

    @Query(value = "SELECT r.* FROM rounds_results r WHERE round_id IN :roundList", nativeQuery = true)
    List<RoundResult> findByRoundIds(@Param("roundList") List<Integer> roundList);
}
