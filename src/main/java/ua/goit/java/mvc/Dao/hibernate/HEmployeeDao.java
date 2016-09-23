package ua.goit.java.mvc.Dao.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.mvc.Dao.EmployeeDao;
import ua.goit.java.mvc.Model.Employee;

import java.util.List;

/**
 * Created by 7 on 02.09.2016.
 */
public class HEmployeeDao implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Transactional
    public void save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    public Employee load(Long id) {
        return null;
    }

    @Transactional
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e").list();
    }

    @Override
    @Transactional
    public Employee findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.name like :name");
        query.setParameter("name", name);

        return (Employee) query.uniqueResult();
    }

    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
