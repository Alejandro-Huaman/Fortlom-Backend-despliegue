package upc.edu.pe.FortlomBackend.backend.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Fanatic;

import upc.edu.pe.FortlomBackend.backend.domain.persistence.FanaticRepository;
import upc.edu.pe.FortlomBackend.backend.domain.service.FanaticService;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;


@Service
public class FanaticImpl implements FanaticService {


    private static final String ENTITY = "Fanatic";

    private final FanaticRepository fanaticRepository;

    private final Validator validator;

    public FanaticImpl(FanaticRepository fanaticRepository,Validator validator){

        this.fanaticRepository=fanaticRepository;
        this.validator=validator;


    }

    public List<Fanatic> getAll() {
        return fanaticRepository.findAll();
    }
    @Override
    public Page<Fanatic> getAll(Pageable pageable) {
        return fanaticRepository.findAll(pageable);
    }
    @Override
    public Fanatic getById(Long fanaticId) {
        return fanaticRepository.findById(fanaticId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, fanaticId));
    }
    @Override
    public Fanatic create(Fanatic request) {
        Set<ConstraintViolation<Fanatic>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return fanaticRepository.save(request);
    }
    @Override
    public Fanatic update(Long fanaticId, Fanatic request) {

        Set<ConstraintViolation<Fanatic>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return fanaticRepository.findById(fanaticId).map(fanatic ->
                fanaticRepository.save(
                        fanatic.withAlias(request.getAlias())
                )

        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, fanaticId));

    }
    @Override
    public ResponseEntity<?> delete(Long fanaticId) {
        return fanaticRepository.findById(fanaticId).map(post -> {
            fanaticRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, fanaticId));
    }
















}
