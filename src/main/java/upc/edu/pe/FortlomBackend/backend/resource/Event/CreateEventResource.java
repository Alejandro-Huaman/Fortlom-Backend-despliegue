package upc.edu.pe.FortlomBackend.backend.resource.Event;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.FortlomBackend.backend.resource.Artist.ArtistResource;

@Getter
@Setter
public class CreateEventResource {
    @NotNull
    @NotBlank
    @Size(max = 30)
    private String EventName;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String EventDescription;

    @NotNull
    private Long Likes;



}
