package aze.coders.springbootcrud.repository;

import aze.coders.springbootcrud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByName(String name);
}
