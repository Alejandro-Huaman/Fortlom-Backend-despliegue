package upc.edu.pe.FortlomBackend.backend.resource.Multimedia;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateMultimediaResource {


    @NotNull
    @NotBlank
    private String Link;



}
