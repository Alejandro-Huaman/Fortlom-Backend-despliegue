package upc.edu.pe.FortlomBackend.backend.resource.Fanatic;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreatedFanaticResource {
    private Long id;
    @NotNull
    @Size(max = 30)
    private String alias;





}
