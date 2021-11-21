package upc.edu.pe.FortlomBackend.backend.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Multimedia")
public class Multimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @NotBlank
    private String Link;

    @ManyToOne(targetEntity = Publication.class)
    @JoinColumn(name = "publicationid")
    private Publication publication;








}
