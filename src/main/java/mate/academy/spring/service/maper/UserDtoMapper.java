package mate.academy.spring.service.maper;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.UserRequestDto;
import mate.academy.spring.model.dto.UserResponseDto;
import mate.academy.spring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    @Autowired
    private CategoryService categoryService;
    public UserResponseDto parse(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setName(user.getName());
        responseDto.setAge(user.getAge());
        responseDto.setCategoryId(user.getCategory().getId());
        return responseDto;
    }

    public User toUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setAge(userRequestDto.getAge());
        user.setName(userRequestDto.getName());
        user.setCategory(categoryService.get(userRequestDto.getCategoryId()));
        return user;
    }
}
