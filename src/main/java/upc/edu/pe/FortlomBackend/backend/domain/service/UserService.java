package upc.edu.pe.FortlomBackend.backend.domain.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.User;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface UserService {

    List<User> getAll();
    Page<User> getAll(Pageable pageable);
    User getById(Long userid);
    User create(User user);
    User update(Long userid,User request);
    ResponseEntity<?> delete(Long userid);

}
