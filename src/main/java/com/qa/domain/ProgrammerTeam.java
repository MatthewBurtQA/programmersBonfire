package com.qa.domain;
import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProgrammerTeam {

    @Id
    @GeneratedValue
    private Long id;
    private String name; // team name

    @OneToMany(mappedBy = "programmer", fetch = FetchType.LAZY)
    private List<Programmer> programmers = new ArrayList<>();

     public ProgrammerTeam() {
     }
     public ProgrammerTeam(String name){
         this.name = name;
     }
     public Long getId(){
         return id;
     }

     public void setId(Long id) {
         this.id = id;
     }
    public String getName(){
         return name;
    }
    public void setName(String name){
         this.name = name;
    }

    public List<Programmer> getProgrammers(){
         return programmers;
    }

    public void setProgrammers(List<Programmer> programmers){
         this.programmers = programmers;
    }

}
