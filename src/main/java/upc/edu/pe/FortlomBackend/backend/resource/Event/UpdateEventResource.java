package upc.edu.pe.FortlomBackend.backend.resource.Event;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEventResource {

    private Long id;

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
