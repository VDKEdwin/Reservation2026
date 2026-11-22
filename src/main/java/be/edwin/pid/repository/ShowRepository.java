
package be.edwin.pid.repository;

import be.edwin.pid.model.Location;
import be.edwin.pid.model.Show;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShowRepository extends CrudRepository<Show, Long> {

    Show findBySlug(String slug);

    Show findByTitle(String title);

    List<Show> findByLocation(Location location);
}
