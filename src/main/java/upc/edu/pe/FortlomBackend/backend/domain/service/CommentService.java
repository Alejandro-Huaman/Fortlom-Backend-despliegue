package upc.edu.pe.FortlomBackend.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAll();
    Page<Comment> getAll(Pageable pageable);
    Comment getById(Long commentId);
    Comment create(Long userId, Long publicationId, Comment comment);
    Comment update(Long commentId, Comment request);
    List<Comment> getCommentByPublicationId(Long publicationId);
    ResponseEntity<?> delete(Long commentId);
}
