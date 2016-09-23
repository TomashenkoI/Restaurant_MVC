package ua.goit.java.mvc.service;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.mvc.Dao.EmployeeDao;
import ua.goit.java.mvc.Model.Employee;

import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public List<Employee> getEmployees(){
        return employeeDao.findAll();
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    public Employee getEmployeeByName(String employeeName) {
        return employeeDao.findByName(employeeName);
    }
}
