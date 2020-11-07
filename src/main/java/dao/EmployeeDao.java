package dao;

import model.Employee;

import java.util.List;

public class EmployeeDao extends Dao implements IDao<Employee> {

    @Override
    public void save(Employee employee) {
        getSession().persist(employee);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> findAll() {
        return (List<Employee>) getSession().createQuery("from Employee").list();
    }
}
