package ua.goit.java.mvc.Dao.hibernate;

import org.hibernate.SessionFactory;
import ua.goit.java.mvc.Dao.OrderDao;
import ua.goit.java.mvc.Model.Order;

/**
 * Created by 7 on 04.09.2016.
 */
public class HOrderDao implements OrderDao{

    private SessionFactory sessionFactory;

    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
