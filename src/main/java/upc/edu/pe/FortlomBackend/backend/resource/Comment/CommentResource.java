package upc.edu.pe.FortlomBackend.backend.resource.Comment;
import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Publication;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.PublicationRepository;
import upc.edu.pe.FortlomBackend.backend.resource.Publication.PublicationResource;
import upc.edu.pe.FortlomBackend.backend.resource.User.UserResource;

import java.util.Date;

@Getter
@Setter
public class CommentResource {

    private Long id;
    private String CommentDescription;
    private String date;
    private UserResource user;
    private PublicationResource publication;
}
