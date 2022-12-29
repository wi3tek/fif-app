package pl.engineerproject.pw.fifapp.repository.helper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import pl.engineerproject.pw.fifapp.model.helper.LeagueTable;

import java.util.List;

@RestResource(exported = false)
@Repository
public interface LeagueTableRepository extends JpaRepository<LeagueTable,Integer> {

    @Query(nativeQuery = true, value = "SELECT l.* from leagues_results l where Liga = :leagueId")
    List<LeagueTable> findByLeagueId(@Param("leagueId") Integer leagueId);
}
