package pl.engineerproject.pw.fifapp.mapper;

import org.modelmapper.ModelMapper;
import pl.engineerproject.pw.fifapp.dto.LeagueDto;
import pl.engineerproject.pw.fifapp.model.League;

public class LeagueMapper {

    public static League dtoToEntity(LeagueDto leagueDto) {
        ModelMapper modelMapper = new ModelMapper();

        League league = modelMapper.map(leagueDto,League.class);
        league.setLeagueId(leagueDto.getLeagueId());

        return league;
    }

    public static LeagueDto entityToDto(League league) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(league,LeagueDto.class);
    }

}
