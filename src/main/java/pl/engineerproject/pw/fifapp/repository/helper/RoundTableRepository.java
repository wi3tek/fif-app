package pl.engineerproject.pw.fifapp.repository.helper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import pl.engineerproject.pw.fifapp.model.helper.LeagueTable;
import pl.engineerproject.pw.fifapp.model.helper.RoundTable;

@RestResource(exported = false)
@Repository
public interface RoundTableRepository extends JpaRepository<RoundTable,Integer> {
}
