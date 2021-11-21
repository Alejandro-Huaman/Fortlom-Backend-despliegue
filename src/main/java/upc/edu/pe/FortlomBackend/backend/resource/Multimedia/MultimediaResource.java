package upc.edu.pe.FortlomBackend.backend.resource.Multimedia;

import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.FortlomBackend.backend.resource.Publication.PublicationResource;

@Getter
@Setter
public class MultimediaResource {


    private Long id;
    private String Link;
    private PublicationResource publication;






}
