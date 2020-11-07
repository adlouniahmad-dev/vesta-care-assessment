package dao;

import model.Location;

import java.util.List;

public class LocationDao extends Dao implements IDao<Location> {

    @Override
    public void save(Location location) {
        getSession().persist(location);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Location> findAll() {
        return (List<Location>) getSession().createQuery("from Location").list();
    }
}
