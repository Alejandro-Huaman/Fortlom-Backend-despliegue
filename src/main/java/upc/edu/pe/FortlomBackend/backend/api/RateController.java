package upc.edu.pe.FortlomBackend.backend.api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Rate;
import upc.edu.pe.FortlomBackend.backend.domain.service.RateService;
import upc.edu.pe.FortlomBackend.backend.mapping.RateMapper;
import upc.edu.pe.FortlomBackend.backend.resource.Rate.CreateRateResource;
import upc.edu.pe.FortlomBackend.backend.resource.Rate.RateResource;
import upc.edu.pe.FortlomBackend.backend.resource.Rate.UpdateRateResource;


@RestController
@RequestMapping("/api/v1")
public class RateController {

    @Autowired
    private RateService rateService;

    @Autowired
    private RateMapper mapper;

    @Autowired
    private ModelMapper mapping;
    @GetMapping("/rates")
    public Page<RateResource> getAllRates(Pageable pageable) {
        return mapper.modelListToPage(rateService.getAll(), pageable);
    }
    @GetMapping("/rates/{rateId}")
    public RateResource getRateById(@PathVariable("rateId") Long followId) {
        return mapper.toResource(rateService.getById(followId));
    }
    @PostMapping("/fanatics/{fanaticId}/artists/{artistId}/rates")
    public RateResource createRate(@PathVariable Long fanaticId, @PathVariable Long artistId, @RequestBody CreateRateResource request) {
        Rate comment = mapping.map(request, Rate.class);
        return mapping.map(rateService.create(fanaticId, artistId, comment), RateResource.class);
    }
    @GetMapping("/fanatics/{fanaticId}/rates")
    public Page<RateResource> getAllRatesByFanaticId(@PathVariable Long fanaticId,Pageable pageable) {
        return mapper.modelListToPage(rateService.ratesByFanaticId(fanaticId), pageable);
    }
    @GetMapping("/artists/{artistId}/rates")
    public Page<RateResource> getAllRateByArtistId(@PathVariable Long artistId,Pageable pageable) {
        return mapper.modelListToPage(rateService.ratesByArtistId(artistId), pageable);
    }
    @DeleteMapping("/rates/{rateId}")
    public ResponseEntity<?> deleteFollow(@PathVariable Long rateId) {
        return rateService.delete(rateId);
    }


    @PutMapping("/rates/{rateId}")
    public RateResource updateRate(@PathVariable Long rateId, @RequestBody UpdateRateResource request) {
        return mapper.toResource(rateService.update(rateId, mapper.toModel(request)));
    }






}
