package upc.edu.pe.FortlomBackend.backend.resource.Rate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class CreateRateResource {

    @NotNull
    private Long rates;





}
