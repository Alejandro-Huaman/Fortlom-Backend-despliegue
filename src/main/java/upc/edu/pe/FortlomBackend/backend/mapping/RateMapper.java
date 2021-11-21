package upc.edu.pe.FortlomBackend.backend.mapping;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Rate;
import upc.edu.pe.FortlomBackend.backend.resource.Rate.CreateRateResource;
import upc.edu.pe.FortlomBackend.backend.resource.Rate.RateResource;
import upc.edu.pe.FortlomBackend.backend.resource.Rate.UpdateRateResource;
import upc.edu.pe.FortlomBackend.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class RateMapper implements Serializable{

    @Autowired
    EnhancedModelMapper mapper;

    public RateResource toResource(Rate model) {
        return mapper.map(model, RateResource.class);
    }

    public Page<RateResource> modelListToPage(List<Rate> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, RateResource.class), pageable, modelList.size());
    }
    public Rate toModel(CreateRateResource resource) {
        return mapper.map(resource, Rate.class);
    }

    public Rate toModel(UpdateRateResource resource) {
        return mapper.map(resource, Rate.class);
    }






}
