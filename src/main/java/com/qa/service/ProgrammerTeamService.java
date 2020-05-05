package com.qa.service;

import com.qa.domain.Programmer;
import com.qa.domain.ProgrammerTeam;

import com.qa.ProgrammerNotFoundException.ProgrammerTeamNotFoundException;

import com.qa.repo.ProgrammerRepository; // might not be needed
import com.qa.repo.ProgrammerTeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammerTeamService {

private final ProgrammerTeamService repo;

@Autowired
    public ProgrammerTeamService(ProgrammerTeamRepository repo){
    this.repo = repo;
}

public  List<ProgrammerTeam> readProgrammerTeams(){
    return this.repo.findAll();
}

public ProgrammerTeam createProgrammerTeam(ProgrammerTeam programmerTeam){
    return this.repo.save(programmerTeam);
}

public ProgrammerTeam findProgrammerTeamById(Long id){
    return this.repo.findById(id).orElseThrow(ProgrammerTeamNotFoundException::new);
}

public ProgrammerTeam updateProgrammerTeam(Long id, Programmer programmer){
    ProgrammerTeam update = findProgrammerTeamById(id);
    update.setName(ProgrammerTeam.getName());
    return this.repo.save(update);
}

public boolean deleteProgrammerTeam(Long id){
    if(!this.repo.existsById(id)){
        throw new ProgrammerTeamNotFoundException();
    }
    this.repo.deleteById(id);
    return this.repo.existsById(id);
}

}
