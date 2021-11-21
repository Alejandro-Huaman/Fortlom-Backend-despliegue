package upc.edu.pe.FortlomBackend.backend.resource.Publication;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdatePublicationResource {

    private Long id;

    @NotNull
    @Size(max = 50)
    private String PublicationName;

    @NotNull
    @Size(max = 500)
    private String PublicationDescription;

    private Long likes;

    private String date;
}
