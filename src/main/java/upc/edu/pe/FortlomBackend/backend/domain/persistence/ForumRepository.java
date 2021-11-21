package upc.edu.pe.FortlomBackend.backend.domain.persistence;

import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Forum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Long>{
    List<Forum> findByUserId(Long userId);
}
