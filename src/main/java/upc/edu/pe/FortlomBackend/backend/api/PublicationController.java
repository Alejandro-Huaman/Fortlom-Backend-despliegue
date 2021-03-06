package upc.edu.pe.FortlomBackend.backend.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Publication;
import upc.edu.pe.FortlomBackend.backend.domain.service.PublicationService;
import upc.edu.pe.FortlomBackend.backend.mapping.PublicationMapper;
import upc.edu.pe.FortlomBackend.backend.resource.Publication.PublicationResource;
import upc.edu.pe.FortlomBackend.backend.resource.Publication.UpdatePublicationResource;
import upc.edu.pe.FortlomBackend.backend.resource.Publication.CreatePublicationResource;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;

    @Autowired
    private PublicationMapper mapper;

    @Autowired
    private ModelMapper mapping;

    @GetMapping("/publications")
    public Page<PublicationResource> getAllPublications(Pageable pageable) {
        return mapper.modelListToPage(publicationService.getAll(), pageable);
    }

    @GetMapping("/publications/{publicationId}")
    public PublicationResource getPublicationById(@PathVariable("publicationId") Long publicationId) {
        return mapper.toResource(publicationService.getById(publicationId));
    }

    @PostMapping("/artists/{artistId}/publications")
    public PublicationResource createPublication(@PathVariable Long artistId,@RequestBody CreatePublicationResource request) {
        Publication publication = mapping.map(request, Publication.class);
        return mapping.map(publicationService.create(artistId, publication), PublicationResource.class);
    }

    @PutMapping("/publications/{publicationId}")
    public PublicationResource updatePublication(@PathVariable Long publicationId, @RequestBody UpdatePublicationResource request) {
        return mapper.toResource(publicationService.update(publicationId, mapper.toModel(request)));
    }

    @DeleteMapping("/publications/{publicationId}")
    public ResponseEntity<?> deletePublication(@PathVariable Long publicationId) {
        return publicationService.delete(publicationId);
    }

    @GetMapping("/artists/{artistId}/publications")
    public Page<PublicationResource> getAllPublicationByArtistId(@PathVariable Long artistId,Pageable pageable) {
        return mapper.modelListToPage(publicationService.getPublicationByArtistId(artistId), pageable);
    }
}
