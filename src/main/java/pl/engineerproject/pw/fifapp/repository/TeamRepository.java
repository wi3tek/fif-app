package pl.engineerproject.pw.fifapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.engineerproject.pw.fifapp.model.Team;

@RestResource(exported=false)
public interface TeamRepository extends JpaRepository<Team,Integer> {
}
