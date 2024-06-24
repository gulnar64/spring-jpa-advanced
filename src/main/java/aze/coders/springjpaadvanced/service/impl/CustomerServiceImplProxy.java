//package aze.coders.springjpaadvanced.service.impl;
//
//import aze.coders.springjpaadvanced.model.CustomerDto;
//import aze.coders.springjpaadvanced.repository.CustomerRepository;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//public class CustomerServiceImplProxy extends CustomerServiceImpl {
//    public CustomerServiceImplProxy(CustomerRepository customerRepository, EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
//        super(customerRepository, entityManagerFactory, entityManager);
//    }
//
//    @Override
//    public List<CustomerDto> getAll() {
//        System.out.println("Start get all service");
//        List<CustomerDto> all = super.getAll();
//        System.out.println("end get all service");
//        return all;    }
//}
