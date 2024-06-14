package aze.coders.springjpaadvanced.service.impl;


import aze.coders.springjpaadvanced.entity.Customer;
import aze.coders.springjpaadvanced.model.CustomerDto;
import aze.coders.springjpaadvanced.repository.CustomerRepository;
import aze.coders.springjpaadvanced.service.CustomerService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
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
    private final EntityManager entityManager;

    @Override
    public List<CustomerDto> getAllCustomers(String name) {
        Specification<Customer> customerSpecification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null && !name.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get(Customer.Fields.name), name));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<Customer> customers = customerRepository.findAll(customerSpecification);
        return customers.stream().map(this::convertEntityToDto).collect(Collectors.toList());
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
}
