package upc.edu.pe.FortlomBackend.backend.mapping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Multimedia;
import upc.edu.pe.FortlomBackend.backend.resource.Multimedia.CreateMultimediaResource;
import upc.edu.pe.FortlomBackend.backend.resource.Multimedia.MultimediaResource;
import upc.edu.pe.FortlomBackend.backend.resource.Multimedia.UpdateMultimediaResource;
import upc.edu.pe.FortlomBackend.shared.mapping.EnhancedModelMapper;

import java.util.List;

public class MultimediaMapper {




    @Autowired
    EnhancedModelMapper mapper;

    public MultimediaResource toResource(Multimedia model) {
        return mapper.map(model, MultimediaResource.class);
    }

    public Page<MultimediaResource> modelListToPage(List<Multimedia> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, MultimediaResource.class), pageable, modelList.size());
    }
    public Multimedia toModel(CreateMultimediaResource resource) {
        return mapper.map(resource, Multimedia.class);
    }

    public Multimedia toModel(UpdateMultimediaResource resource) {
        return mapper.map(resource, Multimedia.class);
    }











}
