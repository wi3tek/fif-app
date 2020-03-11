package pl.engineerproject.pw.fifapp.repository.helper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import pl.engineerproject.pw.fifapp.model.helper.MatchPlayerRel;
import pl.engineerproject.pw.fifapp.model.helper.PlayerMatch;

@RestResource(exported = false)
@Repository
public interface PlayerMatchRepository extends JpaRepository<PlayerMatch, String> {
}
