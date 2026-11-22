
package be.edwin.pid.repository;

import be.edwin.pid.model.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location, Long> {

    Location findByDesignation(String designation);

    Optional<Location> findById(Long id);
}
