package study.tms.users;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.tms.users.exceptions.UserNotFoundException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;
    private final UsersRepository usersRepository;

    @GetMapping
    public Iterable<User> getUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        return usersRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }


}
