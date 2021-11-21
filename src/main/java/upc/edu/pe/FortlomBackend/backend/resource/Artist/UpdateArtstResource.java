package upc.edu.pe.FortlomBackend.backend.resource.Artist;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Setter
@Getter
public class UpdateArtstResource {


    private Long id;

    @NotNull
    private Long followers;


    @NotNull
    private Long tags;


}
