
package be.edwin.pid.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import be.edwin.pid.model.Type;

public interface TypeRepository extends CrudRepository<Type, Long> {

    Type findByType(String type);

    Optional<Type> findById(Long id);
}
