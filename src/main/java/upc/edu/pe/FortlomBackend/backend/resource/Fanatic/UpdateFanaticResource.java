package upc.edu.pe.FortlomBackend.backend.resource.Fanatic;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Setter
@Getter
public class UpdateFanaticResource {
    private Long id;

    @NotNull
    @Size(max = 30)
    private String alias;




}
