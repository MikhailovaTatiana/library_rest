package task.library_rest.service;

import task.library_rest.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAllUsers();
    Optional<Customer> findById(int id);
    Customer saveOrUpdate(Customer user);
    void deleteUser(int id);
}
