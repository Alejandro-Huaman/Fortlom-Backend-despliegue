package upc.edu.pe.FortlomBackend.backend.mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Fanatic;

import upc.edu.pe.FortlomBackend.backend.resource.Fanatic.CreatedFanaticResource;
import upc.edu.pe.FortlomBackend.backend.resource.Fanatic.FanaticResource;
import upc.edu.pe.FortlomBackend.backend.resource.Fanatic.UpdateFanaticResource;
import  upc.edu.pe.FortlomBackend.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;
public class FanaticMapper implements  Serializable{



    @Autowired
    EnhancedModelMapper mapper;

    public FanaticResource toResource(Fanatic model) {
        return mapper.map(model, FanaticResource.class);
    }

    public Page<FanaticResource> modelListToPage(List<Fanatic> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, FanaticResource.class), pageable, modelList.size());
    }
    public Fanatic toModel(CreatedFanaticResource resource) {
        return mapper.map(resource, Fanatic.class);
    }

    public Fanatic toModel(UpdateFanaticResource resource) {
        return mapper.map(resource, Fanatic.class);
    }








}
