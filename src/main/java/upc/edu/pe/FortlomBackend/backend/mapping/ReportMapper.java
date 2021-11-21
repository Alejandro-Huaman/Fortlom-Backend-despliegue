package upc.edu.pe.FortlomBackend.backend.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Report;


import upc.edu.pe.FortlomBackend.backend.resource.Report.CreateReportResource;
import upc.edu.pe.FortlomBackend.backend.resource.Report.ReportResource;
import upc.edu.pe.FortlomBackend.backend.resource.Report.UpdateReportResource;
import upc.edu.pe.FortlomBackend.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class ReportMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public ReportResource toResource(Report model) {
        return mapper.map(model, ReportResource.class);
    }

    public Page<ReportResource> modelListToPage(List<Report> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ReportResource.class), pageable, modelList.size());
    }
    public Report toModel(CreateReportResource resource) {
        return mapper.map(resource, Report.class);
    }

    public Report toModel(UpdateReportResource resource) {
        return mapper.map(resource, Report.class);
    }



}
