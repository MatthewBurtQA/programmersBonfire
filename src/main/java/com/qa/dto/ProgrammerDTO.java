package com.qa.dto;


import com.qa.domain.Programmer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// below is a DTO, which is an object for transfering data. Simples.
public class ProgrammerDTO {
    private Long id; // sets the ID to id, generated using auto gen
    private String name;
    private String surname;
    private int age;
    private String jobroll;

    public ProgrammerDTO(){
         // empty
    }
    // removed the list from this
    public ProgrammerDTO(String name, String surname, int age, String jobroll) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgrammerDTO that = (ProgrammerDTO) o;
        return age == that.age &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(jobroll, that.jobroll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, jobroll);
    }
}
