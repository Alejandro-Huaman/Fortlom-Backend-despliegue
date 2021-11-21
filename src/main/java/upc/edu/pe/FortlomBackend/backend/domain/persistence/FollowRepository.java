package upc.edu.pe.FortlomBackend.backend.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Follow;
import java.util.List;
public interface FollowRepository extends JpaRepository<Follow,Long>{

    List<Follow> findByFanaticId(Long FanaticId);
    List<Follow> findByArtistId(Long ArtistId);


}
