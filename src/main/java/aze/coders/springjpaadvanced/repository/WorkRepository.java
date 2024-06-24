package aze.coders.springjpaadvanced.repository;

import aze.coders.springjpaadvanced.entity.Account;
import aze.coders.springjpaadvanced.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work, Integer>{
}
