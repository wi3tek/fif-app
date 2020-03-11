package pl.engineerproject.pw.fifapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import pl.engineerproject.pw.fifapp.model.Player;
@Repository
@RestResource(exported=false)
public interface PlayerRepository extends JpaRepository<Player,Integer> {
}
