package upc.edu.pe.FortlomBackend.backend.service;

import upc.edu.pe.FortlomBackend.backend.domain.model.entity.User;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.UserRepository;
import upc.edu.pe.FortlomBackend.backend.domain.service.UserService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final String ENTITY = "Usuario";

    private final UserRepository userRepository;

    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository,Validator validator){

        this.userRepository=userRepository;
        this.validator=validator;


    }
    public List<User> getAll() {
        return userRepository.findAll();
    }
    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
    @Override
    public User getById(Long userid) {
        return userRepository.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, userid));
    }

    @Override
    public User create(User request) {
        Set<ConstraintViolation<User>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return userRepository.save(request);
    }

    @Override
    public User update(Long userId, User request) {

        Set<ConstraintViolation<User>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return userRepository.findById(userId).map(user ->
                userRepository.save(
                        user.withName(request.getName())
                                .withLastName(request.getLastName())
                                .withEmail(request.getEmail()))
                                .withPassword(request.getPassword())

        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public ResponseEntity<?> delete(Long userid) {
        return userRepository.findById(userid).map(post -> {
            userRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userid));
    }









}
