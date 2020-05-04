package domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


public class Music {
    private Long id; // sets the ID to id, generated using auto gen
    private String name;
}
