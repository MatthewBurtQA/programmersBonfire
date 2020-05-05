package com.qa.rest;

import com.qa.domain.Programmer;
import com.qa.domain.ProgrammerTeam;

import com.qa.service.ProgrammerTeamService;
import com.qa.service.ProgrammerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProgrammerTeamController {

    private final ProgrammerTeamService service;

    @Autowired
    public ProgrammerTeamController(ProgrammerTeamService service){
        this.service = service;
    }

    @GetMapping("/getAllProgrammerTeams")
    public List<ProgrammerTeam> getAllProgrammers(){
        return this.service.readProgrammerTeams();
    }

    @PostMapping("/createProgrammerTeam")
    public ProgrammerTeam createProgrammer(@RequestBody ProgrammerTeam programmer){
        return this.service.createProgrammerTeam(programmer);
    }

    @DeleteMapping("/deleteProgrammerTeam/{id}")
    public boolean deleteProgrammer(@PathVariable Long id){
        return this.service.deleteProgrammerTeam(id);
    }

    @GetMapping("/getProgrammerTeamById/{id}")
    public ProgrammerTeam getProgrammerTeamById(@PathVariable Long id, @RequestBody ProgrammerTeam programmer){
        return this.service.findProgrammerTeamById(id);
    }

    @PutMapping("/updateProgrammerTeam/{id}")
    public ProgrammerTeam updateProgrammer(@PathVariable Long id,@RequestBody ProgrammerTeam programmer){
        return this.service.updateProgrammerTeam(id, programmer);
    }

}
