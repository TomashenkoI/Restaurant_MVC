package ua.goit.java.mvc.Dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.mvc.Dao.DishDao;
import ua.goit.java.mvc.Model.Dish;

import java.util.List;

/**
 * Created by 7 on 04.09.2016.
 */
public class HDishDao implements DishDao {

    private SessionFactory sessionFactory;

    @Transactional
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    @Transactional
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
