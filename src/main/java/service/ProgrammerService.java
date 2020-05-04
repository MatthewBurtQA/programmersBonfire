package service;

import domain.Programmer;
import ProgrammerNotFoundException.ProgrammerNotFoundException;
import repo.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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

        public Programmer createNote(Programmer programmer){
            return this.repo.save(programmer);
        }

        public Programmer findProgrammerById(Long id){
            return this.repo.findById(id).orElseThrow(NoteNotFoundException::new);
        }

        public Programmer updateProgrammer(Long id, Programmer programmer){
            Programmer update = findNoteById(id);
            update.setTitle(programmer.getTitle());
            update.setDescription(programmer.getDescription());
            return this.repo.save(update);
        }

        public boolean deleteProgrammer(Long id){
            if(!this.repo.existsById(id)){
                throw new NoteNotFoundException();
            }
            this.repo.deleteById(id);
            return this.repo.existsById(id);
        }


    }

