package upc.edu.pe.FortlomBackend.backend.domain.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Artist;

import java.util.List;

public interface ArtistService {


    List<Artist> getAll();
    Page<Artist> getAll(Pageable pageable);
    Artist getById(Long artistId);
    Artist create(Artist artist);
    Artist update(Long artistId,Artist request);
    ResponseEntity<?> delete(Long artistId);





}
