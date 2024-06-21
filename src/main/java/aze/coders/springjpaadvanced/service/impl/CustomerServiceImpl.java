package aze.coders.springjpaadvanced.service.impl;


import aze.coders.springjpaadvanced.entity.Customer;
import aze.coders.springjpaadvanced.model.CustomerDto;
import aze.coders.springjpaadvanced.repository.CustomerRepository;
import aze.coders.springjpaadvanced.service.CustomerService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    @Override
    public List<CustomerDto> getAllCustomers(String name) {
        Specification<Customer> customerSpecification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null && !name.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get(Customer.Fields.address), name));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<Customer> customers = customerRepository.findAll(customerSpecification);
        return customers.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    @SneakyThrows
   @Transactional
    public CustomerDto save(CustomerDto customerDto) {
        // EntityManager entityManager = entityManagerFactory.createEntityManager();
        // EntityTransaction transaction = entityManager.getTransaction();
        Customer customer = convertDtoToEntity(customerDto);
        // transaction.begin();
        System.out.println("persist? " + entityManager.contains(customer));
        System.out.println("customer 1 before save");
        entityManager.persist(customer);
        entityManager.clear();
         customer = entityManager.getReference(Customer.class, customer.getId());
        customer.setName("dsgvdf");
        entityManager.persist(customer);
//        Thread.sleep(1000);
//        entityManager.refresh(customer);
//        System.out.println(entityManager.getDelegate());
//        entityManager.refresh(customer);
//        customer.setName("John");
////        entityManager.clear();
//        System.out.println("customer 2 before save");
//        customer.setAddress("add 2");
//        entityManager.persist(customer);
//        entityManager.flush();
//        System.out.println("customer 3 before save");
//        customer.setName("Customer 4");
//        entityManager.persist(customer);
//        entityManager.flush();
//        System.out.println("persist? " + entityManager.contains(customer));


        // transaction.commit();
        return customerDto;
    }
    // List<Customer> customers = customerRepository.findByName(name);
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
//        Root<Customer> root = criteriaQuery.from(Customer.class);
//        List<Predicate> predicates = new ArrayList<>();
//        if(name != null && !name.isEmpty()) {
//            predicates.add(criteriaBuilder.equal(root.get(Customer.Fields.name), name));
//        }
//        CriteriaQuery<Customer> query = criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
//        List<Customer> customers = entityManager.createQuery(query).getResultList();
//        return customers.stream().map(this::convertEntityToDto).collect(Collectors.toList());

//}

    private CustomerDto convertEntityToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    private Customer convertDtoToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }
}
