package task.library_rest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import task.library_rest.Customer;
import task.library_rest.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImplementation implements CustomerService {

    private CustomerRepository repo;

    @Override
    public List<Customer> findAllUsers() {
        return repo.findAll();
    }

    @Override
    public Optional<Customer> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer user) {
        return repo.save(user);
    }

    @Override
    public void deleteUser(int id) {
        repo.deleteById(id);
    }
}
