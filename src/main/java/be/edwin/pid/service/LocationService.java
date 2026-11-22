
package be.edwin.pid.service;

import be.edwin.pid.model.Location;
import be.edwin.pid.repository.LocationRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repository;

    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();

        repository.findAll().forEach(locations::add);

        return locations;
    }

    public Location get(String id) {
        Long indice = Long.parseLong(id);

        return repository.findById(indice).orElse(null);
    }

    public void add(Location location) {
        repository.save(location);
    }

    public void update(String id, Location location) {
        repository.save(location);
    }

    public void delete(String id) {
        Long indice = Long.parseLong(id);

        repository.deleteById(indice);
    }
}
