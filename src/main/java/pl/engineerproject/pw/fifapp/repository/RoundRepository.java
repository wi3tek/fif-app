package pl.engineerproject.pw.fifapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.engineerproject.pw.fifapp.model.Round;

public interface RoundRepository extends JpaRepository<Round,Integer> {
}
