package pl.engineerproject.pw.fifapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import pl.engineerproject.pw.fifapp.model.Round;

import java.util.List;

@RestResource(exported = false)
@Repository
public interface RoundRepository extends JpaRepository<Round,Integer> {

    @Query(value="SELECT r.* FROM round r WHERE r.league_league_id = :leagueId",nativeQuery = true)
    List<Round> findByLeagueId(@Param("leagueId") Integer leagueId);
}
