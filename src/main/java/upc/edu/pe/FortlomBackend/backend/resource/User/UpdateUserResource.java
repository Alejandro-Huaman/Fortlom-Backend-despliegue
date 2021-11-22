package upc.edu.pe.FortlomBackend.backend.resource.User;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Setter
@Getter
public class UpdateUserResource {


    private Long id;


    @Size(max = 30)
    private String Name;


    @Size(max = 40)
    private String LastName;


    @Size(max = 50)
    private String Email;



    @Size(max = 30)
    private String Password;




}
