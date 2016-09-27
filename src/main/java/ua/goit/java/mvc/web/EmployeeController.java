package ua.goit.java.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.mvc.service.EmployeeService;

import java.util.Map;

/**
 * Created by 7 on 22.09.2016.
 */
@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(Map<String, Object> model){
        model.put("employees", employeeService.getEmployees());
        return "employees";
    }

    @RequestMapping(value = "/employee/{employeeName}", method = RequestMethod.GET)
    public ModelAndView employee(@PathVariable String employeeName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employeeService.getEmployeeByName(employeeName));

        modelAndView.setViewName("employee");

        return modelAndView;
    }

    @RequestMapping(value = "/employees/{employeeName}/delete", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable String employeeName, Map<String, Object> model) {
        employeeService.deleteEmployee(employeeService.getEmployeeByName(employeeName));

        model.put("employees", employeeService.getEmployees());

        return "employees";
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
