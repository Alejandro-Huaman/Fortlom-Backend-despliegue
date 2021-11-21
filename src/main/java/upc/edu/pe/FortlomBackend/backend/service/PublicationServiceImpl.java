package upc.edu.pe.FortlomBackend.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Publication;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.ArtistRepository;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.PublicationRepository;
import upc.edu.pe.FortlomBackend.backend.domain.service.PublicationService;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class PublicationServiceImpl implements PublicationService {

    private static final String ENTITY = "Publication";
    private static final String ENTITY2 = "Artist";

    private final PublicationRepository publicationRepository;
    private final ArtistRepository artistRepository;

    private final Validator validator;

    public PublicationServiceImpl(PublicationRepository PublicationRepository, ArtistRepository artistRepository, Validator validator){

        this.publicationRepository=PublicationRepository;
        this.artistRepository = artistRepository;
        this.validator=validator;
    }

    public List<Publication> getAll() {
        return publicationRepository.findAll();
    }

    @Override
    public Page<Publication> getAll(Pageable pageable) {
        return publicationRepository.findAll(pageable);
    }

    @Override
    public Publication getById(Long publicationId) {
        return publicationRepository.findById(publicationId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));
    }

    @Override
    public Publication create(Long artistId, Publication request) {
        return artistRepository.findById(artistId)
                .map(artists -> {
                    request.setArtist(artists);
                    return publicationRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY2, artistId));
    }

    @Override
    public Publication update(Long publicationId, Publication request) {
        Set<ConstraintViolation<Publication>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return publicationRepository.findById(publicationId).map(event ->
                publicationRepository.save(
                        event
                                .withPublicationName(request.getPublicationName())
                                .withPublicationDescription(request.getPublicationDescription())
                                .withLikes(request.getLikes())
                                .withDate(request.getDate())
                )

        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));
    }

    @Override
    public List<Publication> getPublicationByArtistId(Long artistId) {
        return publicationRepository.findByArtistId(artistId);
    }

    @Override
    public ResponseEntity<?> delete(Long publicationId) {
        return publicationRepository.findById(publicationId).map(post -> {
            publicationRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));
    }
}