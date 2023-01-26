package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.UserResponseDto;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.maper.UserDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private final UserService userService;
    private final UserDtoMapper userDtoMapper;
    @Autowired
    public UserController(UserService userService, UserDtoMapper userDtoMapper) {
        this.userService = userService;
        this.userDtoMapper = userDtoMapper;
    }
    @GetMapping("/")
    public List<UserResponseDto> getAllUser(){
        return userService.getAll()
                .stream()
                .map(userDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable Long id){
        return userDtoMapper.parse(userService.getById(id));
    }

    @GetMapping("/inject")
    public String injectMockData() {
        User lev = new User("Lev",23);
        User vadim = new User("Vadim", 23);
        User andrey = new User("Andrey", 22);

        userService.add(lev);
        userService.add(vadim);
        userService.add(andrey);
        return "Dune!";
    }
}
