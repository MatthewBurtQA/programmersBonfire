package com.qa.repo;

import com.qa.domain.ProgrammerTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammerTeamRepository extends  JpaRepository<ProgrammerTeam, Long>{
}
