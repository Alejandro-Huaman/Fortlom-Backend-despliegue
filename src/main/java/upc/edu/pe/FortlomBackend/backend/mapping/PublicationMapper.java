package upc.edu.pe.FortlomBackend.backend.mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Publication;
import upc.edu.pe.FortlomBackend.backend.resource.Publication.CreatePublicationResource;
import upc.edu.pe.FortlomBackend.backend.resource.Publication.PublicationResource;
import upc.edu.pe.FortlomBackend.backend.resource.Publication.UpdatePublicationResource;
import upc.edu.pe.FortlomBackend.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class PublicationMapper implements  Serializable{

    @Autowired
    EnhancedModelMapper mapper;

    public PublicationResource toResource(Publication model) {
        return mapper.map(model, PublicationResource.class);
    }

    public Page<PublicationResource> modelListToPage(List<Publication> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PublicationResource.class), pageable, modelList.size());
    }
    public Publication toModel(CreatePublicationResource resource) {

        return mapper.map(resource, Publication.class);
    }

    public Publication toModel(UpdatePublicationResource resource) {

        return mapper.map(resource, Publication.class);
    }

}