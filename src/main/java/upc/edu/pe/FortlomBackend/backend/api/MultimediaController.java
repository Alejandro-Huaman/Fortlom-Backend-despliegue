package upc.edu.pe.FortlomBackend.backend.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Multimedia;
import upc.edu.pe.FortlomBackend.backend.domain.service.MultimediaService;
import upc.edu.pe.FortlomBackend.backend.mapping.MultimediaMapper;
import upc.edu.pe.FortlomBackend.backend.resource.Multimedia.CreateMultimediaResource;
import upc.edu.pe.FortlomBackend.backend.resource.Multimedia.MultimediaResource;
import upc.edu.pe.FortlomBackend.backend.resource.Multimedia.UpdateMultimediaResource;


@RestController
@RequestMapping("/api/v1")
public class MultimediaController {


    @Autowired
    private MultimediaService multimediaService;

    @Autowired
    private MultimediaMapper mapper;

    @Autowired
    private ModelMapper mapping;

    @GetMapping("/multimedias")
    public Page<MultimediaResource> getAllMultimedias(Pageable pageable) {
        return mapper.modelListToPage(multimediaService.getAll(), pageable);
    }

    @GetMapping("/multimedias/{multimediaId}")
    public MultimediaResource getCommentById(@PathVariable("multimediaId") Long multimediaId) {
        return mapper.toResource(multimediaService.getById(multimediaId));
    }

    @PostMapping("/publications/{publicationId}/multimedias")
    public MultimediaResource createComment( @PathVariable Long publicationId, @RequestBody CreateMultimediaResource request) {
        Multimedia comment = mapping.map(request, Multimedia.class);
        return mapping.map(multimediaService.create(publicationId, comment), MultimediaResource.class);
    }

    @GetMapping("/publications/{publicationId}/multimedias")
    public Page<MultimediaResource> getAllmultimediasByPublicationId(@PathVariable Long publicationId,Pageable pageable) {
        return mapper.modelListToPage(multimediaService.getMultimediaByPublicationId(publicationId), pageable);
    }

    @PutMapping("/multimedias/{multimediaId}")
    public MultimediaResource updateMultimedia(@PathVariable Long multimediaId, @RequestBody UpdateMultimediaResource request) {
        return mapper.toResource(multimediaService.update(multimediaId, mapper.toModel(request)));
    }

    @DeleteMapping("/multimedias/{multimediaId}")
    public ResponseEntity<?> deleteMultimedia(@PathVariable Long commentId) {
        return multimediaService.delete(commentId);
    }







































}
