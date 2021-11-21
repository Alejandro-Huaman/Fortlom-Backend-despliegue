package upc.edu.pe.FortlomBackend.backend.domain.persistence;

import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByArtistId(Long artistId);
}
