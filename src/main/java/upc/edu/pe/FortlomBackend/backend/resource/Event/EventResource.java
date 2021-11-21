package upc.edu.pe.FortlomBackend.backend.resource.Event;

import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.FortlomBackend.backend.resource.Artist.ArtistResource;

@Getter
@Setter
public class EventResource {
    private Long id;
    private String EventName;
    private String EventDescription;
    private Long Likes;
    private ArtistResource artist;
}
