package service;

import dao.DepartmentDao;
import model.Department;

import java.util.List;

public class DepartmentService {

    private static DepartmentDao departmentDao;

    public DepartmentService() {
        departmentDao = new DepartmentDao();
    }

    public void save(Department department) {
        departmentDao.openSessionWithTransaction();
        departmentDao.save(department);
        departmentDao.closeSessionWithTransaction();
    }

    public List<Department> findAll() {
        departmentDao.openSession();
        List<Department> departments = departmentDao.findAll();
        departmentDao.closeSession();
        return departments;
    }
}
