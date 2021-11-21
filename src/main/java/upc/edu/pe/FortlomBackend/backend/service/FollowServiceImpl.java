package upc.edu.pe.FortlomBackend.backend.service;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Fanatic;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Follow;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.ArtistRepository;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.FanaticRepository;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.FollowRepository;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.UserRepository;
import upc.edu.pe.FortlomBackend.backend.domain.service.FollowService;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceNotFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.List;
import java.util.Set;

@Service
public class FollowServiceImpl implements FollowService {

    private static final String ENTITY = "Follow";
    private final FollowRepository followRepository;
    private final FanaticRepository fanaticRepository;
    private final ArtistRepository artistRepository;
    private final Validator validator;

    public FollowServiceImpl(FollowRepository followRepository,FanaticRepository fanaticRepository,ArtistRepository artistRepository,Validator validator){

        this.followRepository=followRepository;
           this.fanaticRepository=fanaticRepository;
         this.artistRepository=artistRepository;
        this.validator=validator;




    }
    @Override
    public List<Follow> getAll() {
        return followRepository.findAll();
    }

    @Override
    public Page<Follow> getAll(Pageable pageable) {
        return followRepository.findAll(pageable);
    }
    @Override
    public Follow getById(Long FollowId) {
        return followRepository.findById(FollowId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, FollowId));
    }
    @Override
    public Follow create(Long FanaticId, Long ArtistId, Follow request) {
        Fanatic fanatic = fanaticRepository.findById(FanaticId)
                .orElseThrow(() -> new ResourceNotFoundException("Fanatic", FanaticId));
        return artistRepository.findById(ArtistId)
                .map(artists -> {
                    request.setArtist(artists);
                    request.setFanatic(fanatic);
                    return followRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Artist", ArtistId));
    }
    @Override
    public List<Follow> followsByFanaticId(Long FanaticId) {
        return followRepository.findByFanaticId(FanaticId);
    }
    @Override
    public List<Follow> followsByArtistId(Long ArtistId) {
        return followRepository.findByArtistId(ArtistId);
    }
    @Override
    public ResponseEntity<?> delete(Long FollowId) {
        return followRepository.findById(FollowId).map(post -> {
            followRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, FollowId));
    }

















}
