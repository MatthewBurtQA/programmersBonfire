package com.qa.domain;

import javax.persistence.*;

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

}
