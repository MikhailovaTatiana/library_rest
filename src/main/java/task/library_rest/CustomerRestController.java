package task.library_rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import task.library_rest.service.CustomerService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "/library")
public class CustomerRestController {

    private final CustomerService serv;

    @GetMapping("/users")
    public List<Customer> getUsers(){
        return serv.findAllUsers();
    }

    @GetMapping(path = "/findUser/{id}")
    public Optional<Customer> getUserById(@PathVariable int id) {
        log.info("Try to get user by email {}", id);
        return serv.findById(id);
    }

    @PostMapping("/addUser")
    public Customer newUser(@RequestBody Customer user){
        log.info("Saving new user information");
        return serv.saveOrUpdate(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id) {
        serv.deleteUser(id);
    }

    @PutMapping("/updateUser/{id}")
    Customer replaceUser(@RequestBody Customer newUser, @PathVariable int id) {

        return serv.findById(id)
                .map(user -> {
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    user.setRole(newUser.getRole());
                    return serv.saveOrUpdate(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return serv.saveOrUpdate(newUser);
                });
    }
}
