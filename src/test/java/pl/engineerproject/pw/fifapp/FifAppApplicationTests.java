package pl.engineerproject.pw.fifapp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.engineerproject.pw.fifapp.controller.TeamController;
import pl.engineerproject.pw.fifapp.converter.RoundConverter;
import pl.engineerproject.pw.fifapp.converter.UserConverter;
import pl.engineerproject.pw.fifapp.dto.PlayerDto;
import pl.engineerproject.pw.fifapp.dto.RoundDto;
import pl.engineerproject.pw.fifapp.dto.UserDto;
import pl.engineerproject.pw.fifapp.model.League;
import pl.engineerproject.pw.fifapp.model.Round;
import pl.engineerproject.pw.fifapp.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.constraints.AssertTrue;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@SpringBootTest
class FifAppApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	public void checkUserConverter() {

//		UserDto userDto = new UserDto(1,"ANdrzej","hasło2012","","",1,"",null);
//		User user = UserConverter.dtoToEntity(userDto);
//
//		assertEquals(user.getId(),userDto.getId());
//		assertEquals(user.getUsername(),userDto.getUsername());
//		assertEquals(user.getPassword(),userDto.getPassword());
	}


	@Test
	public void checkRoundConverter() throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		League league = new League("Nazwa ligi", "opis",null,null,"Wrocław",null);
		league.setLeagueId(1);
		Round round = new Round(df.parse("2019-01-02"),1,"description12312",league,null,null);


		RoundDto roundDto = RoundConverter.entityToDto(round);

		assertEquals(roundDto.getLeagueId(),round.getLeague().getLeagueId());
		assertEquals(roundDto.getLeagueDescription(),round.getLeague().getDescription());
		assertEquals(roundDto.getLeagueName(),round.getLeague().getName());
		assertEquals(roundDto.getLeagueStartDate(),round.getLeague().getStartDate());
		assertEquals(roundDto.getLeagueLocation(),round.getLeague().getLocation());


	}



}
