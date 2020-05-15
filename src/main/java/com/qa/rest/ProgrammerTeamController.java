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
import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/programmerTeam") // NEW
public class ProgrammerTeamController {

    private final ProgrammerTeamService service;

    @Autowired
    public ProgrammerTeamController(ProgrammerTeamService service){
        super(); // added on the 15th...heh.
        this.service = service;
    }

    @GetMapping("/getAllProgrammerTeams")
    public ResponseEntity<List<ProgrammerTeamDTO>> getAllProgrammerTeams() {
        return ResponseEntity.ok(this.service.readProgrammerTeams());
    }

    @PostMapping("/createProgrammerTeam")
    public ResponseEntity<ProgrammerTeamDTO> createProgrammerTeam(@RequestBody ProgrammerTeam programmerTeam){
        return new ResponseEntity<ProgrammerTeamDTO>(this.service.createProgrammerTeam(programmerTeam), HttpStatus.CREATED);
    }


    @DeleteMapping("/deleteProgrammerTeam/{id}")
    public ResponseEntity<?> deleteProgrammerTeam(@PathVariable Long id){
    return this.service.deleteProgrammerTeam(id)
            ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
            : ResponseEntity.noContent().build();
    }

    @GetMapping("/getProgrammerTeamById/{id}")
    public ResponseEntity<ProgrammerTeamDTO> getProgrammerTeamById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findProgrammerTeamById(id));
    }

    @PutMapping("/updateProgrammerTeam")
    public ResponseEntity<ProgrammerTeamDTO> updateProgrammerTeam(@PathParam("id") Long id, @RequestBody ProgrammerTeam team){
        return new ResponseEntity<ProgrammerTeamDTO>(this.service.updateProgrammerTeam(id, team), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateProgrammerTeam/{id}")
    public ResponseEntity<ProgrammerTeamDTO> addProgrammerToProgrammerTeam(@PathVariable Long id, @RequestBody Programmer programmer){
        return new ResponseEntity<ProgrammerTeamDTO>(this.service.addProgrammerToProgrammerTeam(id, programmer), HttpStatus.ACCEPTED);
    }


    //@PutMapping("/updateProgrammerTeam/{id}")
    //public ProgrammerTeam updateProgrammerTeam(@PathVariable Long id, @RequestBody ProgrammerTeam programmer){
    //    return this.service.updateProgrammerTeam(id, programmer);
    //}



}
