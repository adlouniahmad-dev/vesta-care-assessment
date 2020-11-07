package dao;

import model.Department;

import java.util.List;

public class DepartmentDao extends Dao implements IDao<Department> {

    @Override
    public void save(Department department) {
        getSession().persist(department);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Department> findAll() {
        return (List<Department>) getSession().createQuery("from Department").list();
    }
}
