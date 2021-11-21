package upc.edu.pe.FortlomBackend.backend.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Artist;

import upc.edu.pe.FortlomBackend.backend.resource.Artist.ArtistResource;
import upc.edu.pe.FortlomBackend.backend.resource.Artist.CreateArtistResource;
import upc.edu.pe.FortlomBackend.backend.resource.Artist.UpdateArtstResource;
import upc.edu.pe.FortlomBackend.backend.resource.Fanatic.CreatedFanaticResource;
import upc.edu.pe.FortlomBackend.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;
public class ArtistMapper implements  Serializable{

    @Autowired
    EnhancedModelMapper mapper;


    public ArtistResource toResource(Artist model) {
        return mapper.map(model, ArtistResource.class);
    }

    public Page<ArtistResource> modelListToPage(List<Artist> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ArtistResource.class), pageable, modelList.size());
    }
    public Artist toModel(CreateArtistResource resource) {
        return mapper.map(resource, Artist.class);
    }

    public Artist toModel(UpdateArtstResource resource) {
        return mapper.map(resource, Artist.class);
    }



}
