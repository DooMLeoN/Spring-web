package mate.academy.spring.service;

import mate.academy.spring.model.Category;

public interface CategoryService {
    Category create(Category category);

    Category get(Long id);
}
