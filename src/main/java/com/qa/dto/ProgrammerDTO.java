package com.qa.dto;


import com.qa.domain.Programmer;
import java.util.ArrayList;
import java.util.List;


public class ProgrammerDTO {
    private Long id; // sets the ID to id, generated using auto gen
    private String name;
    private String surname;
    private int age;
    private String jobroll;

    public ProgrammerDTO(){
         // empty
    }

    public ProgrammerDTO(String name, String surname, int age, String jobroll, List<ProgrammerDTO> programmers) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.jobroll = jobroll;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name){this.name = name;}

    public String getSurname(){return surname;}
    public void setSurname(String surname){this.surname = surname;}

    public int getAge(){return age;}
    public void setAge(int age){this.age = age;}

    public String getJobroll(){return  jobroll;}
    public void setJobroll(String jobroll){this.jobroll = jobroll;}

}
