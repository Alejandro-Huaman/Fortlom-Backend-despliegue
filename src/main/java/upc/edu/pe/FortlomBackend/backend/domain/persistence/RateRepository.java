package upc.edu.pe.FortlomBackend.backend.domain.persistence;


import org.springframework.data.jpa.repository.JpaRepository;


import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Rate;

import java.util.List;

public interface RateRepository extends JpaRepository<Rate,Long> {

    List<Rate> findByFanaticId(Long FanaticId);
    List<Rate> findByArtistId(Long ArtistId);


}
