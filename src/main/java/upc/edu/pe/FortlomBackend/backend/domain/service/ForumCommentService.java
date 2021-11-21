package upc.edu.pe.FortlomBackend.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.ForumComment;

import java.util.List;

public interface ForumCommentService {

    List<ForumComment> getAll();
    Page<ForumComment> getAll(Pageable pageable);
    ForumComment getById(Long forumcommentId);
    ForumComment create(Long userId, Long forumId, ForumComment forumcomment);
    ForumComment update(Long forumcommentId, ForumComment request);
    List<ForumComment> getForumCommentByForumId(Long forumId);
    ResponseEntity<?> delete(Long forumcommentId);
}
