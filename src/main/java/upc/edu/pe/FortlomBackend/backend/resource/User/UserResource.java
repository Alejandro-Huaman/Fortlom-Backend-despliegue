package upc.edu.pe.FortlomBackend.backend.resource.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserResource {
    private Long id;
    private String Name;
    private String LastName;
    private String Email;
    private String password;


}
