package upc.edu.pe.FortlomBackend.backend.domain.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Fanatic;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.User;
import org.springframework.http.ResponseEntity;
import java.util.List;


public interface FanaticService {


    List<Fanatic> getAll();
    Page<Fanatic> getAll(Pageable pageable);
    Fanatic getById(Long fanaticId);
    Fanatic create(Fanatic fanatic);
    Fanatic update(Long fanaticId,Fanatic request);
    ResponseEntity<?> delete(Long fanaticId);




}
