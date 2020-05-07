package com.qa.domain;

import javax.persistence.*;
import java.util.Objects;

//below line states this class will be an entity in the databasse

@Entity
public class Programmer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // sets the ID to id, generated using auto gen
    private String name;
    private String surname;
    private int age;
    private String jobroll;

    public Programmer(){
        // empty constructor for blanks
    }

    public Programmer(String name, String surname, int age, String jobroll){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.jobroll = jobroll;
    }

    @ManyToOne(targetEntity = ProgrammerTeam.class)
    private ProgrammerTeam programmer;

    public Long getId() {return id;}
    public void setId(Long id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getSurname(){return surname;}
    public void setSurname(String surname){this.surname = surname;}

    public int getAge(){return age;}
    public void setAge(int age){this.age = age;}

    public String getJobroll() {return jobroll;}
    public void setJobroll(String jobroll){this.jobroll = jobroll;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Programmer that = (Programmer) o;
        return age == that.age &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(jobroll, that.jobroll) &&
                Objects.equals(programmer, that.programmer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, jobroll, programmer);
    }
}
