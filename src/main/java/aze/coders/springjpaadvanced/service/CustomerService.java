package aze.coders.springjpaadvanced.service;

import aze.coders.springjpaadvanced.entity.Customer;
import aze.coders.springjpaadvanced.model.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers(String name);
    CustomerDto save(CustomerDto customerDto);
    List<CustomerDto> getAll();
    void getAllTest();
}
