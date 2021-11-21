package upc.edu.pe.FortlomBackend.backend.resource;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateUserResource {

    @NotNull
    @Size(max = 30)
    private String Name;

    @NotNull
    @Size(max = 40)
    private String LastName;

    @NotNull
    @Size(max = 50)
    private String Email;


    @NotNull
    @Size(max = 30)
    private String Password;






}
