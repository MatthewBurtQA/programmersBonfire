package com.qa.service;

import com.qa.domain.Programmer;
import com.qa.domain.ProgrammerTeam;
import com.qa.dto.ProgrammerTeamDTO;
import com.qa.ProgrammerNotFoundException.ProgrammerTeamNotFoundException;
import com.qa.repo.ProgrammerRepository;
import com.qa.repo.ProgrammerTeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgrammerTeamService {

    private final ProgrammerTeamRepository programmerTeamRepository;
    private final ProgrammerRepository programmerRepository;
    private final ModelMapper mapper;

    @Autowired
    public ProgrammerTeamService(ProgrammerTeamRepository programmerTeamRepository,
            ProgrammerRepository programmerRepository, ModelMapper mapper) {
        this.programmerTeamRepository = programmerTeamRepository;
        this.programmerRepository = programmerRepository;
        this.mapper = mapper;

        //this.repo = repo;
        //this.mapper = mapper;
    }

    private ProgrammerTeamDTO mapToDTO(ProgrammerTeam programmerTeam) {
        return this.mapper.map(programmerTeam, ProgrammerTeamDTO.class);
    }

    public List<ProgrammerTeamDTO> readProgrammerTeams()
    {
        return this.programmerTeamRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());

    }

    public ProgrammerTeamDTO createProgrammerTeam(ProgrammerTeam programmerTeam) {

        return this.mapToDTO(this.programmerTeamRepository.save(programmerTeam));
    }

    public ProgrammerTeamDTO findProgrammerTeamById(Long id) {
        //return this.mapToDTO(this.programmerTeamRepository.findById(id).orElseThrow(ProgrammerTeamNotFoundException::new));
        return this.mapToDTO(this.programmerTeamRepository.findById(id).orElseThrow(ProgrammerTeamNotFoundException::new));

        //return this.repo.findById(id).orElseThrow(ProgrammerTeamNotFoundException::new);
    }

    public ProgrammerTeamDTO updateProgrammerTeam(Long id, ProgrammerTeam team) {
        ProgrammerTeam toUpdate = this.programmerTeamRepository.findById(id).orElseThrow(ProgrammerTeamNotFoundException::new);
        toUpdate.setName(team.getName());
        return this.mapToDTO(this.programmerTeamRepository.save(toUpdate));
    }

    public boolean deleteProgrammerTeam(Long id) {
        if (!this.programmerTeamRepository.existsById(id)) {
            throw new ProgrammerTeamNotFoundException();
        }
        this.programmerTeamRepository.deleteById(id);
        return this.programmerTeamRepository.existsById(id);
    }

    public ProgrammerTeamDTO addProgrammerToProgrammerTeam(Long id, Programmer programmer){
        ProgrammerTeam toUpdate = this.programmerTeamRepository.findById(id).orElseThrow(ProgrammerTeamNotFoundException::new);
        Programmer tmp = this.programmerRepository.save(programmer); // save to temp var then VVV
        toUpdate.getProgrammers().add(tmp); // added temp to programmerTeam
        return this.mapToDTO(this.programmerTeamRepository.saveAndFlush(toUpdate));
    }
}
