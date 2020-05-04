package repo;


import domain.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammerRepository<Programmer, Long> {

    Programmer findByName(String name); // may be wrong

}
