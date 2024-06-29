package aze.coders.springjpaadvanced.repository;

import aze.coders.springjpaadvanced.entity.Account;
import aze.coders.springjpaadvanced.entity.Customer;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    //@Query(nativeQuery = true, value = "select * from accounts a where a.id =:id for update")
    @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    Optional<Account> findById(int id);
}
