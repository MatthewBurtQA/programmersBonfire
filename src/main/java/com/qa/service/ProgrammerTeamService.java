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

    private final ProgrammerTeamRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public ProgrammerTeamService(ProgrammerTeamRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private ProgrammerTeamDTO mapToDTO(ProgrammerTeam programmerTeam) {
        return this.mapper.map(programmerTeam, ProgrammerTeamDTO.class);
    }

    public List<ProgrammerTeamDTO> readProgrammerTeams()
    {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());

        //return this.repo.findAll();
    }

    public ProgrammerTeamDTO createProgrammerTeam(ProgrammerTeam programmerTeam) {

        //return this.repo.save(programmerTeam);
        return this.mapToDTO(this.repo.save(programmerTeam));
    }

    public ProgrammerTeam findProgrammerTeamById(Long id) {
        return this.repo.findById(id).orElseThrow(ProgrammerTeamNotFoundException::new);
    }

  //  public ProgrammerTeam updateProgrammerTeam(Long id, Programmer programmer) {
    //    ProgrammerTeam update = findProgrammerTeamById(id);
      //  update.setName(programmer.getName());
        //return this.repo.save(update);
   // }

    public boolean deleteProgrammerTeam(Long id) {
        if (!this.repo.existsById(id)) {
            throw new ProgrammerTeamNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

    public ProgrammerTeamDTO addProgrammerToProgrammerTeam(Long id, Programmer programmer){
        ProgrammerTeam progTeam = this.ProgrammerTeamRepository.findByID(id).orElseThrow()
    }

}
