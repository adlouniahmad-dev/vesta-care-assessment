package service;

import dao.LocationDao;
import model.Location;

import java.util.List;

public class LocationService {

    private static LocationDao locationDao;

    public LocationService() {
        locationDao = new LocationDao();
    }

    public void save(Location location) {
        locationDao.openSessionWithTransaction();
        locationDao.save(location);
        locationDao.closeSessionWithTransaction();
    }

    public List<Location> findAll() {
        locationDao.openSession();
        List<Location> locations = locationDao.findAll();
        locationDao.closeSession();
        return locations;
    }

}
