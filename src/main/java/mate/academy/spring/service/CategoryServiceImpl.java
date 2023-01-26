package mate.academy.spring.service;

import mate.academy.spring.dao.CategoryDao;
import mate.academy.spring.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category create(Category category) {
        return categoryDao.create(category);
    }

    @Override
    public Category get(Long id) {
        return categoryDao.get(id).orElseThrow(RuntimeException::new);
    }
}
