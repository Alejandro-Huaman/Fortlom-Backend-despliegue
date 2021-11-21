package upc.edu.pe.FortlomBackend.backend.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.ForumComment;

import java.util.List;

public interface ForumCommentRepository extends JpaRepository<ForumComment,Long>{
    List<ForumComment> findByForumId(Long forumId);
}
