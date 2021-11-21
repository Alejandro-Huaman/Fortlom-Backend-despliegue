package upc.edu.pe.FortlomBackend.backend.resource.Report;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateReportResource {


    @NotNull
    @Size(max = 100)
    private String ReportDescription;


}
