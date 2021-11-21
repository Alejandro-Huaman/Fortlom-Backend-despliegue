package upc.edu.pe.FortlomBackend.backend.domain.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Report;


import java.util.List;

public interface ReportRepository extends JpaRepository<Report,Long> {



    List<Report> findByUserMainId(Long UserMainId);
    List<Report> findByUserReportedId(Long UserReportedId);







}
