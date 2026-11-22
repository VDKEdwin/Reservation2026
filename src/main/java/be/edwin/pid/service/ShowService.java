
package be.edwin.pid.service;

import be.edwin.pid.model.Location;
import be.edwin.pid.model.Show;
import be.edwin.pid.repository.ShowRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    private ShowRepository repository;

    public List<Show> getAll() {
        List<Show> shows = new ArrayList<>();
        repository.findAll().forEach(shows::add);
        return shows;
    }

    public Show get(String id) {
        Long indice = Long.parseLong(id);
        return repository.findById(indice).orElse(null);
    }

    public void add(Show show) {
        repository.save(show);
    }

    public void update(String id, Show show) {
        repository.save(show);
    }

    public void delete(String id) {
        Long indice = Long.parseLong(id);
        repository.deleteById(indice);
    }

    public List<Show> getFromLocation(Location location) {
        return repository.findByLocation(location);
    }
}
