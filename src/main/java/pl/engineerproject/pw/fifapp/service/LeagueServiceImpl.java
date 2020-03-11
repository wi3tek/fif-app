package pl.engineerproject.pw.fifapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.engineerproject.pw.fifapp.converter.LeagueConverter;
import pl.engineerproject.pw.fifapp.dto.LeagueDto;
import pl.engineerproject.pw.fifapp.repository.LeagueRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueServiceImpl implements LeagueService{

    @Autowired
    LeagueRepository leagueRepository;

    @Override
    public LeagueDto getLeagueById(Integer leagueId) {
        return LeagueConverter.entityToDto(leagueRepository.getOne(leagueId));
    }

    @Override
    public void saveLeague(LeagueDto leagueDto) {
        leagueRepository.save(LeagueConverter.dtoToEntity(leagueDto));
    }

    @Override
    public List<LeagueDto> getAllLeagues() {
        return leagueRepository.findAll(Sort.by(Sort.Direction.DESC,"startDate")).stream().map(LeagueConverter::entityToDto).collect(Collectors.toList());
    }

}
