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
import java.util.Date;

/*
"id": 1,
"CommentDescription": "You really going to like it",
"PublicationID": 1,
"UserID": 1,
"Date": "10/9/2020"
*/

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 150)
    private String CommentDescription;

    @NotNull
    @Size(max = 50)
    private String date;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne(targetEntity = Publication.class)
    @JoinColumn(name = "publicationid")
    private Publication publication;
}
