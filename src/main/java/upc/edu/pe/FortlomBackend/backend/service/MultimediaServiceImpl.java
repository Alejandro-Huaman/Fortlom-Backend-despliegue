package upc.edu.pe.FortlomBackend.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Comment;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Multimedia;


import upc.edu.pe.FortlomBackend.backend.domain.persistence.MultimediaRepository;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.PublicationRepository;

import upc.edu.pe.FortlomBackend.backend.domain.service.MultimediaService;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class MultimediaServiceImpl implements MultimediaService {

    private static final String ENTITY = "Multimedia";

    private final MultimediaRepository multimediaRepository;

    private final PublicationRepository publicationRepository;

    private final Validator validator;



    public MultimediaServiceImpl(MultimediaRepository multimediaRepository, PublicationRepository publicationRepository, Validator validator){

        this.multimediaRepository=multimediaRepository;
        this.publicationRepository = publicationRepository;
        this.validator=validator;
    }
    public List<Multimedia> getAll() {
        return multimediaRepository.findAll();
    }

    @Override
    public Page<Multimedia> getAll(Pageable pageable) {
        return multimediaRepository.findAll(pageable);
    }
    @Override
    public Multimedia getById(Long multimediaId) {
        return multimediaRepository.findById(multimediaId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, multimediaId));
    }
    @Override
    public Multimedia create(Long publicationId, Multimedia request) {

        return publicationRepository.findById(publicationId)
                .map(publications -> {
                    request.setPublication(publications);
                    return multimediaRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Publication", publicationId));
    }
    @Override
    public Multimedia update(Long multimediaId, Multimedia request) {
        Set<ConstraintViolation<Multimedia>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return multimediaRepository.findById(multimediaId).map(event ->
                multimediaRepository.save(
                        event
                                .withLink(request.getLink())

                )

        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, multimediaId));
    }

    @Override
    public List<Multimedia> getMultimediaByPublicationId(Long multimediaId) {
        return multimediaRepository.findByPublicationId(multimediaId);
    }

    @Override
    public ResponseEntity<?> delete(Long multimediaId) {
        return multimediaRepository.findById(multimediaId).map(post -> {
            multimediaRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, multimediaId));
    }










}
