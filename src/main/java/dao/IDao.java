package dao;


import java.util.List;


public interface IDao<T> {
    void save(T entity);
    List<T> findAll();
}
