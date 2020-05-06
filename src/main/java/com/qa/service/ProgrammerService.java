package com.qa.service;

import com.qa.domain.Programmer;
import com.qa.dto.ProgrammerDTO;
import com.qa.ProgrammerNotFoundException.ProgrammerNotFoundException;
import com.qa.repo.ProgrammerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProgrammerService {

    private final ProgrammerRepository repo;

    private final ModelMapper mapper; // this is new to me

    @Autowired
    public ProgrammerService(ProgrammerRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private ProgrammerDTO mapToDTO(Programmer programmer) { return this.mapper.map(programmer, ProgrammerDTO.class); }


    public List<ProgrammerDTO> readProgrammers(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public ProgrammerDTO createProgrammer(Programmer programmer){
        Programmer tempProgrammer = this.repo.save(programmer);
        return this.mapToDTO(tempProgrammer);
        //return this.repo.save(programmer);
    }

    public ProgrammerDTO findProgrammerById(Long id){
        //return this.repo.findById(id).orElseThrow(ProgrammerNotFoundException::new);
        return this.mapToDTO(this.repo.findById(id).orElseThrow(ProgrammerNotFoundException::new));
    }

    public ProgrammerDTO updateProgrammer(Long id, Programmer programmer){
        //Programmer update = findProgrammerById(id);
        Programmer update = this.repo.findById(id).orElseThrow(ProgrammerNotFoundException::new);
        update.setName(programmer.getName());
        update.setSurname(programmer.getSurname());
        update.setAge(programmer.getAge());
        update.setJobroll(programmer.getJobroll());
        Programmer tempProgrammer = this.repo.save(programmer);
        return this.mapToDTO(tempProgrammer);
    }
    public boolean deleteProgrammer(Long id){
        if(!this.repo.existsById(id)){
            throw new ProgrammerNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}

