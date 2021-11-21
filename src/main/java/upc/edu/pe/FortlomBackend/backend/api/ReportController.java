package upc.edu.pe.FortlomBackend.backend.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Report;
import upc.edu.pe.FortlomBackend.backend.domain.service.ReportInterface;
import upc.edu.pe.FortlomBackend.backend.mapping.ReportMapper;
import upc.edu.pe.FortlomBackend.backend.resource.Report.CreateReportResource;
import upc.edu.pe.FortlomBackend.backend.resource.Report.ReportResource;
import upc.edu.pe.FortlomBackend.backend.resource.Report.UpdateReportResource;


@RestController
@RequestMapping("/api/v1")
public class ReportController {


    @Autowired
    private ReportInterface reportservice;

    @Autowired
    private ReportMapper mapper;

    @Autowired
    private ModelMapper mapping;
    @GetMapping("/reports")
    public Page<ReportResource> getAllRates(Pageable pageable) {
        return mapper.modelListToPage(reportservice.getAll(), pageable);
    }
    @GetMapping("/reports/{reportId}")
    public ReportResource getRateById(@PathVariable("reportId") Long followId) {
        return mapper.toResource(reportservice.getById(followId));
    }
    @PostMapping("/usersmains/{UserMainId}/usersreports/{UserReportedId}/reports")
    public ReportResource createRate(@PathVariable Long UserMainId, @PathVariable Long UserReportedId, @RequestBody CreateReportResource request) {
        Report comment = mapping.map(request, Report.class);
        return mapping.map(reportservice.create(UserMainId, UserReportedId, comment), ReportResource.class);
    }
    @GetMapping("/usersmains/{UserMainId}/reports")
    public Page<ReportResource> getAllRatesByFanaticId(@PathVariable Long UserMainId,Pageable pageable) {
        return mapper.modelListToPage(reportservice.findByUserMainId(UserMainId), pageable);
    }
    @GetMapping("/usersreports/{UserReportedId}/reports")
    public Page<ReportResource> getAllRateByArtistId(@PathVariable Long UserReportedId,Pageable pageable) {
        return mapper.modelListToPage(reportservice.findByUserReportedId(UserReportedId), pageable);
    }
    @DeleteMapping("/reports/{reportId}")
    public ResponseEntity<?> deleteFollow(@PathVariable Long rateId) {
        return reportservice.delete(rateId);
    }


    @PutMapping("/reports/{reportId}")
    public ReportResource updateRate(@PathVariable Long reportId, @RequestBody UpdateReportResource request) {
        return mapper.toResource(reportservice.update(reportId, mapper.toModel(request)));
    }























}
