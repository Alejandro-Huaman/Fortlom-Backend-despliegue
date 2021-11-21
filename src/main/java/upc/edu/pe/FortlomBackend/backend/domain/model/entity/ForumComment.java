package upc.edu.pe.FortlomBackend.backend.domain.model.entity;


import lombok.*;
import org.hibernate.annotations.Type;
import upc.edu.pe.FortlomBackend.shared.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ForumComment")
public class ForumComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 150)
    @Column(unique = true)
    private String ForumCommentDescription;

    @NotNull
    @Column(unique = true)
    @Size(max = 50)
    private String date;

    @ManyToOne(targetEntity = Forum.class)
    @JoinColumn(name = "forumid")
    private Forum forum;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userid")
    private User user;
}