package com.qa.rest;

import com.qa.domain.Programmer;
import com.qa.domain.ProgrammerTeam;
import com.qa.dto.ProgrammerDTO;
import com.qa.dto.ProgrammerTeamDTO;
import com.qa.service.ProgrammerTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ProgrammerTeamController {

    private final ProgrammerTeamService service;

    @Autowired
    public ProgrammerTeamController(ProgrammerTeamService service){
        this.service = service;
    }

    @GetMapping("/getAllProgrammerTeams")
   // public List<ProgrammerTeam> getAllProgrammers(){
     //   return this.service.readProgrammerTeams();
    //}
    public ResponseEntity<List<ProgrammerTeamDTO>> getAllProgrammers() {
        return ResponseEntity.ok(this.service.readProgrammerTeams());
    }
    //should be post
    @PostMapping("/createProgrammerTeam")
    public ResponseEntity<ProgrammerTeamDTO> createProgrammer(@RequestBody ProgrammerTeam programmer){
        return new ResponseEntity<ProgrammerTeamDTO>(this.service.createProgrammerTeam(programmer), HttpStatus.CREATED);
    }


   // public ProgrammerTeam createProgrammer(@RequestBody ProgrammerTeam programmer){
  //      return this.service.createProgrammerTeam(programmer);
   // }

    @DeleteMapping("/deleteProgrammerTeam/{id}")
    //public boolean deleteProgrammer(@PathVariable Long id){
      //  return this.service.deleteProgrammerTeam(id);
    //}
    public ResponseEntity<?> deleteProgrammer(@PathVariable Long id){
    return this.service.deleteProgrammerTeam(id)
            ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
            : ResponseEntity.noContent().build();
    }

    @GetMapping("/getProgrammerTeamById/{id}")
    public ResponseEntity<ProgrammerTeamDTO> getProgrammerById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findProgrammerTeamById(id));
    }

//    @PutMapping("/updateProgrammerTeam/{id}")
//    public ResponseEntity<ProgrammerTeamDTO> updateProgrammer(@PathVariable Long id, @RequestBody ProgrammerTeam programmer){
//        return ResponseEntity.ok(this.service.updateProgrammerTeam(id, programmer));
//    }


    //public ProgrammerTeam getProgrammerTeamById(@PathVariable Long id, @RequestBody ProgrammerTeam programmer){
    //    return this.service.findProgrammerTeamById(id);
    //}

    //@PutMapping("/updateProgrammerTeam/{id}")
    //public ProgrammerTeam updateProgrammer(@PathVariable Long id, @RequestBody ProgrammerTeam programmer){
    //    return this.service.updateProgrammerTeam(id, programmer);
    //}

//    @PutMapping("/updateProgrammerTeam")
//    public ProgrammerTeam updateProgrammer(@PathParam("id") Long id, @RequestBody Programmer programmer){
//        return this.service.updateProgrammerTeam(id, programmer);
//    }

}
