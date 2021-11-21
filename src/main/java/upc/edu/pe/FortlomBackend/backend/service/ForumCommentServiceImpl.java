package upc.edu.pe.FortlomBackend.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.ForumComment;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.User;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.ForumCommentRepository;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.ForumRepository;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.UserRepository;
import upc.edu.pe.FortlomBackend.backend.domain.service.ForumCommentService;
import upc.edu.pe.FortlomBackend.backend.resource.ForumComment.ForumCommentResource;
import upc.edu.pe.FortlomBackend.backend.resource.ForumComment.CreateForumCommentResource;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ForumCommentServiceImpl implements ForumCommentService {

    private static final String ENTITY = "ForumComment";

    private final ForumCommentRepository forumcommentRepository;
    private final UserRepository userRepository;
    private final ForumRepository forumRepository;

    private final Validator validator;

    public ForumCommentServiceImpl(ForumCommentRepository forumcommentRepository, UserRepository userRepository, ForumRepository forumRepository, Validator validator){
        this.forumcommentRepository= forumcommentRepository;
        this.userRepository = userRepository;
        this.forumRepository = forumRepository;
        this.validator=validator;
    }

    public List<ForumComment> getAll() {
        return forumcommentRepository.findAll();
    }

    @Override
    public Page<ForumComment> getAll(Pageable pageable) {
        return forumcommentRepository.findAll(pageable);
    }

    @Override
    public ForumComment getById(Long forumcommentId) {
        return forumcommentRepository.findById(forumcommentId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, forumcommentId));
    }

    @Override
    public ForumComment create(Long userId, Long forumId, ForumComment request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", userId));
        return forumRepository.findById(forumId)
                .map(forums -> {
                    request.setForum(forums);
                    request.setUser(user);
                    return forumcommentRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Forum", forumId));
    }

    @Override
    public ForumComment update(Long forumcommentId, ForumComment request) {
        Set<ConstraintViolation<ForumComment>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return forumcommentRepository.findById(forumcommentId).map(event ->
                forumcommentRepository.save(
                        event
                                .withForumCommentDescription(request.getForumCommentDescription())
                                .withDate(request.getDate())
                )

        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, forumcommentId));
    }

    @Override
    public List<ForumComment> getForumCommentByForumId(Long forumId) {
        return forumcommentRepository.findByForumId(forumId);
    }

    @Override
    public ResponseEntity<?> delete(Long forumcommentId) {
        return forumcommentRepository.findById(forumcommentId).map(forumComment -> {
            forumcommentRepository.delete(forumComment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, forumcommentId));
    }
}