package upc.edu.pe.FortlomBackend.backend.resource.Artist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateArtistResource {

    private Long Id;
    @NotNull
    private Long followers;


    @NotNull
    private Long tags;



}
