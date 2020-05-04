package com.qa.service;

import com.qa.domain.Programmer;
import com.qa.ProgrammerNotFoundException.ProgrammerNotFoundException;
import com.qa.repo.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammerService {

    private final ProgrammerRepository repo;

    @Autowired
    public ProgrammerService(ProgrammerRepository repo) {
        this.repo = repo;
    }

    public List<Programmer> readProgrammers(){
        return this.repo.findAll();
    }

    public Programmer createProgrammer(Programmer programmer){
        return this.repo.save(programmer);
    }

    public Programmer findProgrammerById(Long id){
        return this.repo.findById(id).orElseThrow(ProgrammerNotFoundException::new);
    }

    //name, surname,

    public Programmer updateProgrammer(Long id, Programmer programmer){
        Programmer update = findProgrammerById(id);
        update.setName(programmer.getName());
        update.setSurname(programmer.getSurname());
        update.setAge(programmer.getAge());
        update.setJobroll(programmer.getJobroll());
        return this.repo.save(update);
    }

    public boolean deleteProgrammer(Long id){
        if(!this.repo.existsById(id)){
            throw new ProgrammerNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }


}

