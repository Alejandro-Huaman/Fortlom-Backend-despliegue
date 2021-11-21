package upc.edu.pe.FortlomBackend.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Comment;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.User;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.CommentRepository;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.PublicationRepository;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.UserRepository;
import upc.edu.pe.FortlomBackend.backend.domain.service.CommentService;
import upc.edu.pe.FortlomBackend.backend.resource.Comment.CommentResource;
import upc.edu.pe.FortlomBackend.backend.resource.Comment.CreateCommentResource;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class CommentServiceImpl implements CommentService {

    private static final String ENTITY = "Comment";

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PublicationRepository publicationRepository;

    private final Validator validator;

    public CommentServiceImpl(CommentRepository CommentRepository, UserRepository userRepository, PublicationRepository publicationRepository, Validator validator){

        this.commentRepository=CommentRepository;
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
        this.validator=validator;
    }

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public Page<Comment> getAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Comment getById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public Comment create(Long userId, Long publicationId, Comment request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", userId));
        return publicationRepository.findById(publicationId)
                .map(publications -> {
                    request.setPublication(publications);
                    request.setUser(user);
                    return commentRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Publication", publicationId));
    }

    @Override
    public Comment update(Long commentId, Comment request) {
        Set<ConstraintViolation<Comment>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return commentRepository.findById(commentId).map(event ->
                commentRepository.save(
                        event
                                .withCommentDescription(request.getCommentDescription())
                                .withDate(request.getDate())
                )

        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public List<Comment> getCommentByPublicationId(Long publicationId) {
        return commentRepository.findByPublicationId(publicationId);
    }

    @Override
    public ResponseEntity<?> delete(Long commentId) {
        return commentRepository.findById(commentId).map(post -> {
            commentRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }
}