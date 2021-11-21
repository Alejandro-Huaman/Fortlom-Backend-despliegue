package upc.edu.pe.FortlomBackend.backend.domain.persistence;



import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.User;

import java.util.List;
import java.util.Optional;
public interface  UserRepository extends JpaRepository<User,Long> {





}
