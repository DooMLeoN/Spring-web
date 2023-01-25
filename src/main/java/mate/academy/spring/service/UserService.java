package mate.academy.spring.service;

import mate.academy.spring.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User add(User user);

    List<User> getAll();
}
