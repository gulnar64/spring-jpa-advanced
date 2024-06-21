package aze.coders.springjpaadvanced.repository;

import aze.coders.springjpaadvanced.entity.Identification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentificationRepository extends JpaRepository<Identification, Integer> {
}
