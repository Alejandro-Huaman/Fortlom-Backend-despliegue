package upc.edu.pe.FortlomBackend.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Multimedia;

import java.util.List;

public interface MultimediaService {

    List<Multimedia> getAll();
    Page<Multimedia> getAll(Pageable pageable);
    Multimedia getById(Long multimediaId);
    Multimedia create(Long multimediaId, Multimedia multimedia);
    Multimedia update(Long multimediaId, Multimedia request);
    List<Multimedia> getMultimediaByPublicationId(Long multimediaId);
    ResponseEntity<?> delete(Long commentId);



}
