package mate.academy.spring.dao;

import mate.academy.spring.model.Category;

import java.util.Optional;

public interface CategoryDao {
    Category create(Category category);

    Optional<Category> get(Long id);

}
