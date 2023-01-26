package mate.academy.spring.dao;

import mate.academy.spring.model.Category;
import mate.academy.spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public CategoryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Category create(Category category) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't save category to DB: " + category);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return category;    }

    @Override
    public Optional<Category> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT p FROM User p WHERE p.id =: id",
                    Category.class).setParameter("id", id).uniqueResultOptional();
        } catch (Exception e) {
            throw new RuntimeException("Can't get all users from DB!");
        }
    }
}
