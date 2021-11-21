package upc.edu.pe.FortlomBackend.backend.resource.Forum;

import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.FortlomBackend.backend.resource.Artist.ArtistResource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateForumResource {
    @NotNull
    @NotBlank
    @Size(max = 30)
    private String ForumName;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String ForumDescription;

}
