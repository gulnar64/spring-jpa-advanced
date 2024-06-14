package aze.coders.springbootcrud.service;

import aze.coders.springbootcrud.model.CustomerDto;
import aze.coders.springbootcrud.model.CustomersDtoResponse;

public interface CustomerService {
    CustomersDtoResponse getAllCustomers();

    CustomerDto getCustomer(Integer id);

    CustomersDtoResponse getCustomerByName(String name);

    void deleteCustomer(Integer id);

    void saveCustomer(CustomerDto customerDto);

    void updateCustomer(Integer id, String name);

    void updateCustomerWithPatch(Integer id, String name);
}
