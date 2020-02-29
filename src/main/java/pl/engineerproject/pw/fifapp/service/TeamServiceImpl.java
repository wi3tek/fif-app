package pl.engineerproject.pw.fifapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.engineerproject.pw.fifapp.converter.TeamConverter;
import pl.engineerproject.pw.fifapp.dto.TeamDto;
import pl.engineerproject.pw.fifapp.repository.TeamRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Override
    public TeamDto getTeamById(Integer teamId){
        return TeamConverter.entityToDto(teamRepository.getOne(teamId   ));
    }

    @Override
    public List<TeamDto> getTeamsList() {
        return teamRepository.findAll().stream().map(TeamConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    public void addTeam(TeamDto teamDto) {
        teamRepository.save(TeamConverter.dtoToEntity(teamDto));
    }

    @Override
    public void deleteTeam(TeamDto teamDto) {
        teamRepository.delete(TeamConverter.dtoToEntity(teamDto));
    }
}

