package pl.engineerproject.pw.fifapp.repository.helper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.engineerproject.pw.fifapp.model.helper.RoundResult;

@Repository
public interface RoundsResultsRepository extends JpaRepository<RoundResult,String> {
}
