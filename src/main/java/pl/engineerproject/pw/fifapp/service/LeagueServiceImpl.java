package pl.engineerproject.pw.fifapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.engineerproject.pw.fifapp.mapper.LeagueMapper;
import pl.engineerproject.pw.fifapp.mapper.UserMapper;
import pl.engineerproject.pw.fifapp.dto.LeagueDto;
import pl.engineerproject.pw.fifapp.model.League;
import pl.engineerproject.pw.fifapp.model.User;
import pl.engineerproject.pw.fifapp.repository.LeagueRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class    LeagueServiceImpl implements LeagueService{

    @Autowired
    LeagueRepository leagueRepository;

    @Autowired
    UserService userService;

    @Override
    public LeagueDto getLeagueById(Integer leagueId) {
        return LeagueMapper.entityToDto(leagueRepository.getOne(leagueId));
    }

    @Override
    public void saveLeague(LeagueDto leagueDto) {
        User user = UserMapper.dtoToEntity(userService.getUserById(leagueDto.getOwnerId()));
        League league = LeagueMapper.dtoToEntity(leagueDto);
        league.setOwner(user);

        leagueRepository.save(league);
    }

    @Override
    public List<LeagueDto> getAllLeagues() {
        return leagueRepository.findAll(Sort.by(Sort.Direction.DESC,"startDate")).stream().map( LeagueMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteLeague(Integer leagueId) {
        leagueRepository.deleteById(leagueId);
    }

    public void updateLeague(LeagueDto leagueDto) {
        leagueRepository.save( LeagueMapper.dtoToEntity(leagueDto));
    }

}
