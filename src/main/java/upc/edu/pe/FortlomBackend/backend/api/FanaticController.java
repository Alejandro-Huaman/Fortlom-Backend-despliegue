package upc.edu.pe.FortlomBackend.backend.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.FortlomBackend.backend.domain.service.FanaticService;
import upc.edu.pe.FortlomBackend.backend.mapping.FanaticMapper;
import upc.edu.pe.FortlomBackend.backend.resource.Fanatic.CreatedFanaticResource;
import upc.edu.pe.FortlomBackend.backend.resource.Fanatic.FanaticResource;
import upc.edu.pe.FortlomBackend.backend.resource.Fanatic.UpdateFanaticResource;



@RestController
@RequestMapping("/api/v1/fanatics")
public class FanaticController {

    @Autowired
    private FanaticService fanaticService;

    @Autowired
    private FanaticMapper mapper;



    @GetMapping
    public Page<FanaticResource> getAllFanatics(Pageable pageable) {
        return mapper.modelListToPage(fanaticService.getAll(), pageable);
    }
    @GetMapping("{fanaticId}")
    public FanaticResource getUserById(@PathVariable("fanaticId") Long fanaticId) {
        return mapper.toResource(fanaticService.getById(fanaticId));
    }
    @PostMapping
    public FanaticResource createUser(@RequestBody CreatedFanaticResource request) {

        return mapper.toResource(fanaticService.create(mapper.toModel(request)));
    }
    @PutMapping("{fanaticId}")
    public FanaticResource updateUser(@PathVariable Long fanaticId, @RequestBody UpdateFanaticResource request) {
        return mapper.toResource(fanaticService.update(fanaticId, mapper.toModel(request)));
    }
    @DeleteMapping("{fanaticId}")
    public ResponseEntity<?> deletePost(@PathVariable Long fanaticId) {
        return fanaticService.delete(fanaticId);
    }






}
