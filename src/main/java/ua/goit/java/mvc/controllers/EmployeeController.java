package ua.goit.java.mvc.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.mvc.Dao.EmployeeDao;
import ua.goit.java.mvc.Model.Employee;
import ua.goit.java.mvc.Model.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 7 on 02.09.2016.
 */
public class EmployeeController {

    private EmployeeDao employeeDao;
    private DishController dishController;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    @Transactional
    public void createEmployee(){

        Set<Employee> allEmployees = new HashSet<Employee>(employeeDao.findAll());

        Employee employee = new Employee();
//        employee.setId(1L);
//        employee.setName("John");
//        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("555-55-55");
        employee.setSalary(25000.0F);

        if (allEmployees.contains(employee)){
            employeeDao.save(employee);
        }
    }

    @Transactional
    public List<Employee> getAllEmployees(){
        return employeeDao.findAll();
    }

    public Employee getEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }



}
