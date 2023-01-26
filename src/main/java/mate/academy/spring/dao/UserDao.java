package mate.academy.spring.dao;

import mate.academy.spring.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> getUserById(Long id);
    List<User> getAll();
}
