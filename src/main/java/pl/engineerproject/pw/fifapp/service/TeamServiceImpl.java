package pl.engineerproject.pw.fifapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.engineerproject.pw.fifapp.mapper.TeamMapper;
import pl.engineerproject.pw.fifapp.dto.TeamDto;
import pl.engineerproject.pw.fifapp.repository.TeamRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Override
    public TeamDto getTeamById(Integer teamId){
        return TeamMapper.entityToDto(teamRepository.getOne(teamId   ));
    }

    @Override
    public List<TeamDto> getTeamsList() {
        return teamRepository.findAll().stream().map( TeamMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public void addTeam(TeamDto teamDto) {
        teamRepository.save( TeamMapper.dtoToEntity(teamDto));
    }

    @Override
    public void deleteTeam(TeamDto teamDto) {
        teamRepository.delete( TeamMapper.dtoToEntity(teamDto));
    }


}

