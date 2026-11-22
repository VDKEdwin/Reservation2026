
package be.edwin.pid.repository;

import org.springframework.data.repository.CrudRepository;
import be.edwin.pid.model.Locality;

public interface LocalityRepository extends CrudRepository<Locality, Long> {

    Locality findByPostalCode(String postalCode);

    Locality findByLocality(String locality);
}
