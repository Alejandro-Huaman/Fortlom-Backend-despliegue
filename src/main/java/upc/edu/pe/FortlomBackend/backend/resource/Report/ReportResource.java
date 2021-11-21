package upc.edu.pe.FortlomBackend.backend.resource.Report;

import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.User;
import upc.edu.pe.FortlomBackend.backend.resource.UserResource;

@Getter
@Setter
public class ReportResource {


    private Long id;

    private String ReportDescription;

    private UserResource userMain;


    private UserResource userReported;



}
