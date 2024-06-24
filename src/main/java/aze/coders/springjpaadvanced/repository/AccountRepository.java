package aze.coders.springjpaadvanced.repository;

import aze.coders.springjpaadvanced.entity.Account;
import aze.coders.springjpaadvanced.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer>{
}
