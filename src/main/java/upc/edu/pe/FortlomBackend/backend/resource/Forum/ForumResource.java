package upc.edu.pe.FortlomBackend.backend.resource.Forum;

import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.FortlomBackend.backend.resource.Artist.ArtistResource;
import upc.edu.pe.FortlomBackend.backend.resource.User.UserResource;

@Getter
@Setter
public class ForumResource {
    private Long id;
    private String ForumName;
    private String ForumDescription;
    private UserResource user;
}
