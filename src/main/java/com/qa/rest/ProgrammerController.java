package com.qa.rest;


import com.qa.domain.Programmer;
import com.qa.domain.ProgrammerTeam;
import com.qa.dto.ProgrammerDTO;
import com.qa.service.ProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import javax.xml.ws.Response;
import java.util.List;

@RestController
public class ProgrammerController {

    private final ProgrammerService service;

    @Autowired
    public ProgrammerController(ProgrammerService service) {this.service = service; }

    @GetMapping("/getAllProgrammers") //DTOtime
    //public List<Programmer> getAllProgrammers() {return this.service.readProgrammers(); }
    public ResponseEntity<List<ProgrammerDTO>> getAllProgrammers() {return ResponseEntity.ok(this.service.readProgrammers()); }

    @PostMapping("/createProgrammer")
    public ResponseEntity<ProgrammerDTO> createProgrammer(@RequestBody Programmer programmer) {
        return new ResponseEntity<ProgrammerDTO>(this.service.createProgrammer(programmer), HttpStatus.CREATED);

    }

        @DeleteMapping("/deleteProgrammer/{id}")
   // public boolean deleteNote(@PathVariable Long id){
   //     return this.service.deleteProgrammer(id);
    //}
        public ResponseEntity<?> deleteNote(@PathVariable Long id){
        return this.service.deleteProgrammer(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
        }

    @GetMapping("/getProgrammerById/{id}")
    //public Programmer getProgrammerByID(@PathVariable Long id, @RequestBody Programmer programmer)
    //{return this.service.findProgrammerById(id);}
    public ResponseEntity<ProgrammerDTO> getProgrammerById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findProgrammerById(id));

    }

    @GetMapping("/updateProgrammer/{id}")
    public ResponseEntity<ProgrammerDTO> updateProgrammer(@PathVariable Long id, @RequestBody Programmer programmer){
        return ResponseEntity.ok(this.service.updateProgrammer(id, programmer));
    }
    //below could be wrong

   // @PutMapping("/updateProgrammer")
    //public Programmer updateProgrammer(@PathParam("id") Long id, @RequestBody Programmer programmer){
     //   return this.service.updateProgrammer(id, programmer);
    //}

}

