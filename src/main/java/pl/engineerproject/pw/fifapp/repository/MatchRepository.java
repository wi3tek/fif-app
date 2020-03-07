package pl.engineerproject.pw.fifapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import pl.engineerproject.pw.fifapp.model.MatchData;
@RestResource(exported=false)
@Repository
public interface MatchRepository extends JpaRepository<MatchData,Integer> {
}
