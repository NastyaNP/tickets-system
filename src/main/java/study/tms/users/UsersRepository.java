package study.tms.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<User, Long> {

    @Query("SELECT user FROM User user WHERE lower(user.firstName) LIKE lower(concat('%', ?1, '%')) OR lower(user.lastName) LIKE lower(concat('%', ?1, '%'))")
    List<User> searchByName(String name);
}
