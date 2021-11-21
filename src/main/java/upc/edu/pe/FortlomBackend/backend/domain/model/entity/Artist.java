package upc.edu.pe.FortlomBackend.backend.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Type;
import upc.edu.pe.FortlomBackend.shared.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "Artist")
public class Artist{

    @Id
    private Long id;

    @NotNull
    @Column()
    private Long tags;

    @NotNull
    @Column()
    private Long followers;

    @OneToMany(targetEntity = Event.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "artistid",referencedColumnName = "id")
    private List<Event> events;
    
    @OneToMany(targetEntity = Publication.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "artistid",referencedColumnName = "id")
    private List<Publication> publications;
}
