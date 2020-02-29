package pl.engineerproject.pw.fifapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.engineerproject.pw.fifapp.model.MatchData;

public interface MatchRepository extends JpaRepository<MatchData,Integer> {
}
