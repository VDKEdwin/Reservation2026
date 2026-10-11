package be.edwin.pid.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import be.edwin.pid.model.Artist ;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
    List<Artist> findByLastname(String lastname);

    Artist findById(long id);
}
