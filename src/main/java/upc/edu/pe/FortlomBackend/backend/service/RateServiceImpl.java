package upc.edu.pe.FortlomBackend.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Fanatic;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Rate;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.ArtistRepository;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.FanaticRepository;

import upc.edu.pe.FortlomBackend.backend.domain.persistence.RateRepository;
import upc.edu.pe.FortlomBackend.backend.domain.service.RateService;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class RateServiceImpl implements RateService {


    private static final String ENTITY = "Rate";
    private final RateRepository rateRepository;
    private final FanaticRepository fanaticRepository;
    private final ArtistRepository artistRepository;
    private final Validator validator;


    public RateServiceImpl(RateRepository rateRepository, FanaticRepository fanaticRepository, ArtistRepository artistRepository, Validator validator){

        this.rateRepository=rateRepository;
        this.fanaticRepository=fanaticRepository;
        this.artistRepository=artistRepository;
        this.validator=validator;


    }
    @Override
    public List<Rate> getAll() {
        return rateRepository.findAll();
    }

    @Override
    public Page<Rate> getAll(Pageable pageable) {
        return rateRepository.findAll(pageable);
    }
    @Override
    public Rate getById(Long rateId) {
        return rateRepository.findById(rateId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, rateId));
    }
    @Override
    public Rate create(Long FanaticId, Long ArtistId, Rate request) {
        Fanatic faan = fanaticRepository.findById(FanaticId)
                .orElseThrow(() -> new ResourceNotFoundException("Fanatic", FanaticId));
        return artistRepository.findById(ArtistId)
                .map(artist -> {
                    request.setArtist(artist);
                    request.setFanatic(faan);
                    return rateRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Artist", ArtistId));

    }

    @Override
    public List<Rate> ratesByFanaticId(Long FanaticId) {
        return rateRepository.findByFanaticId(FanaticId);
    }
    @Override
    public List<Rate> ratesByArtistId(Long ArtistId) {
        return rateRepository.findByArtistId(ArtistId);
    }
    @Override
    public ResponseEntity<?> delete(Long FollowId) {
        return rateRepository.findById(FollowId).map(post -> {
            rateRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, FollowId));
    }


    @Override
    public Rate update(Long rateId, Rate request) {
        Set<ConstraintViolation<Rate>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return rateRepository.findById(rateId).map(event ->
                rateRepository.save(
                        event
                                .withRates(request.getRates())

                )

        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, rateId));
    }












}
