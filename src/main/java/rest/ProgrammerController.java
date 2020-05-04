package rest;


import domain.Programmer;
import service.ProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;

import java.util.List;

@RestController
public class ProgrammerController {

    private final ProgrammerService service;

    @Autowired
    public ProgrammerController(ProgrammerController service) {this.service = service; }

    @GetMapping("/getAllProgrammers")
    public List<Programmer> getAllProgrammers() {return this.service.readProgrammers(); }

    @GetMapping("/createProgrammer")
    public Programmer createProgrammer(@RequestBody Programmer programmer)
    {return this.service.createProgrammer(programmer);}


    @DeleteMapping("/deleteNote/{id}")
    public boolean deleteNote(@PathVariable Long id){
        return this.service.deleteProgrammer(id);
    }

    @GetMapping("/getProgrammerById/{id}")
    public Programmer getProgrammerByID(@PathVariable Long id, @RequestBody Programmer programmer)
    {return this.service.findProgrammerById(id);}


}

