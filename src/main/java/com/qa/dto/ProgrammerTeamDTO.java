package com.qa.dto;
import com.qa.domain.Programmer;
import java.util.ArrayList;
import java.util.List;


public class ProgrammerTeamDTO {

    private Long id;
    private String name;
    private List<ProgrammerDTO> programmers;

    public ProgrammerTeamDTO() {
        /// empty constructor ///
    }

    public ProgrammerTeamDTO(String name, List<ProgrammerDTO> programmers) {
        super();
        this.name = name;
        this.programmers = programmers;

    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getName() { return name; }
    public void setName(String name){ this.name = name;}

    public List<ProgrammerDTO>  getProgrammers() {return  programmers;}
    public void setProgrammers(List<ProgrammerDTO> programmers) {this.programmers = programmers;}


}