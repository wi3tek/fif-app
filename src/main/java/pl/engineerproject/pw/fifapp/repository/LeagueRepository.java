package pl.engineerproject.pw.fifapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.engineerproject.pw.fifapp.model.League;

@RestResource(exported=false) // ta adnotacja mówi, żeby Spring Boot nie eksportował metod jako punktów końcowych REST
public interface LeagueRepository extends JpaRepository<League, Integer> {  // klasa encji i typ jej klucza podstawowego
// dzięki temu interfejsowi springboot zapewnia implementację operacji CRUD



}
