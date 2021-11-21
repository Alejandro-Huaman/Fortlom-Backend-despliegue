package upc.edu.pe.FortlomBackend.backend.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Artist;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.ArtistRepository;
import upc.edu.pe.FortlomBackend.backend.domain.service.ArtistService;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;



@Service
public class ArtistServiceImpl implements ArtistService {


    private static final String ENTITY = "Artist";

    private final ArtistRepository artistRepository;

    private final Validator validator;

    public ArtistServiceImpl(ArtistRepository artistRepository, Validator validator){

        this.artistRepository=artistRepository;
        this.validator=validator;


    }


    public List<Artist> getAll() {
        return artistRepository.findAll();
    }
    @Override
    public Page<Artist> getAll(Pageable pageable) {
        return artistRepository.findAll(pageable);
    }
    @Override
    public Artist getById(Long artistId) {
        return artistRepository.findById(artistId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, artistId));
    }
    @Override
    public Artist create(Artist request) {
        Set<ConstraintViolation<Artist>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return artistRepository.save(request);
    }
    @Override
    public Artist update(Long artistId, Artist request) {

        Set<ConstraintViolation<Artist>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return artistRepository.findById(artistId).map(artist ->
                artistRepository.save(
                        artist.withFollowers(request.getFollowers())
                                .withTags(request.getFollowers())
                )

        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artistId));

    }
    @Override
    public ResponseEntity<?> delete(Long artistId) {
        return artistRepository.findById(artistId).map(post -> {
            artistRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artistId));
    }









}
