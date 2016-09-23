package ua.goit.java.mvc.Dao;

import ua.goit.java.mvc.Model.Employee;

import java.util.List;

/**
 * Created by 7 on 02.09.2016.
 */
public interface EmployeeDao {

    void save(Employee employee);

    Employee load(Long id);

    List<Employee> findAll();

    void remove(Employee employee);

    Employee findByName(String name);

}
