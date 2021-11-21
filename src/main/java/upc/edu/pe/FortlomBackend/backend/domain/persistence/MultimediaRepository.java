package upc.edu.pe.FortlomBackend.backend.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Multimedia;

import java.util.List;

public interface MultimediaRepository extends JpaRepository<Multimedia,Long> {


    List<Multimedia> findByPublicationId(Long publicationId);




}
