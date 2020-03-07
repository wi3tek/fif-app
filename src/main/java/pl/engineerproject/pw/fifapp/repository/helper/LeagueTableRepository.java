package pl.engineerproject.pw.fifapp.repository.helper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import pl.engineerproject.pw.fifapp.model.helper.LeagueTable;

@RestResource(exported = false)
@Repository
public interface LeagueTableRepository extends JpaRepository<LeagueTable,Integer> {
}
