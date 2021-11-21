package upc.edu.pe.FortlomBackend.backend.resource.Follow;

import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.FortlomBackend.backend.resource.Artist.ArtistResource;
import upc.edu.pe.FortlomBackend.backend.resource.Fanatic.FanaticResource;
@Getter
@Setter
public class FollowResource {

    private Long id;
    private ArtistResource artist;
    private FanaticResource fanatic;
}
