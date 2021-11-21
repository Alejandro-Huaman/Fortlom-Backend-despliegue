package upc.edu.pe.FortlomBackend.backend.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column()
    private Long rates;



    @ManyToOne(targetEntity = Artist.class)
    @JoinColumn(name = "artistid")
    private Artist artist;


    @ManyToOne(targetEntity = Fanatic.class)
    @JoinColumn(name = "fanaticid")
    private Fanatic fanatic;


}
