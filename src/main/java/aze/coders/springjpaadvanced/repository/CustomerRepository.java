package aze.coders.springjpaadvanced.repository;

import aze.coders.springjpaadvanced.entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
    @Query("select c from Customer c where (:name is null or c.name = :name)")

    List<Customer> findByName(String name);
   // @Query("select c from Customer c left join fetch c.accounts")
    @Query("select c from Customer  c")
    @EntityGraph(value = "customer.accounts", type = EntityGraph.EntityGraphType.LOAD)
    List<Customer> findAll();

}
