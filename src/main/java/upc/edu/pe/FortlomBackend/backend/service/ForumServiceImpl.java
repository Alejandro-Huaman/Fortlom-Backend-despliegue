package upc.edu.pe.FortlomBackend.backend.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Forum;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.ArtistRepository;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.ForumRepository;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.UserRepository;
import upc.edu.pe.FortlomBackend.backend.domain.service.ForumService;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ForumServiceImpl implements ForumService {
    private static final String ENTITY = "Forum";
    private static final String ENTITY2 = "User";

    private final ForumRepository forumRepository;
    private final UserRepository userRepository;

    private final Validator validator;
    
    public ForumServiceImpl(ForumRepository forumRepository,UserRepository userRepository, javax.validation.Validator validator){
        this.forumRepository=forumRepository;
        this.validator=validator;
        this.userRepository=userRepository;
    }

    public List<Forum> getAllForums() {
        return forumRepository.findAll();
    }
    @Override
    public Page<Forum> getAllForums(Pageable pageable) {
        return forumRepository.findAll(pageable);
    }
    @Override
    public Forum getForumById(Long forumId) {
        return forumRepository.findById(forumId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, forumId));
    }
    @Override
    public Forum createForum(Long userId,Forum request) {
        return userRepository.findById(userId)
                .map(users -> {
                    request.setUser(users);
                    return forumRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY2, userId));
    }

    @Override
    public Forum updateForum(Long forumId, Forum request) {
        Set<ConstraintViolation<Forum>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return forumRepository.findById(forumId).map( forum ->
                forumRepository.save(
                        forum.withForumName(request.getForumName())
                                .withForumDescription(request.getForumDescription())
                )
        ).orElseThrow( () -> new ResourceNotFoundException(ENTITY,forumId));
    }

    @Override
    public List<Forum> getForumsByUserId(Long userId) {
        return forumRepository.findByUserId(userId);
    }
    @Override
    public ResponseEntity<?> deleteForum(Long ForumId) {
        return forumRepository.findById(ForumId).map(Forum -> {
            forumRepository.delete(Forum);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, ForumId));
    }
}
