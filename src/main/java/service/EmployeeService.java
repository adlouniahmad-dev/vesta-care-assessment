package service;

import dao.EmployeeDao;
import model.Employee;

import java.util.List;

public class EmployeeService {

    private static EmployeeDao employeeDao;

    public EmployeeService() {
        employeeDao = new EmployeeDao();
    }

    public void save(Employee employee) {
        employeeDao.openSessionWithTransaction();
        employeeDao.save(employee);
        employeeDao.closeSessionWithTransaction();
    }

    public List<Employee> findAll() {
        employeeDao.openSession();
        List<Employee> employees = employeeDao.findAll();
        employeeDao.closeSession();
        return employees;
    }
}
