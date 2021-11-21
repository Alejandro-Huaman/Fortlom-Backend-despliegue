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
import java.util.List;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Forum")
public class Forum{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 20)
    @Column(unique = true)
    private String ForumName;


    @NotNull
    @NotBlank
    @Size(max = 200)
    @Column(unique = true)
    private String ForumDescription;



    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userid")
    private User user;

    @OneToMany(targetEntity = ForumComment.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "forumid",referencedColumnName = "id")
    private List<ForumComment> forumComments;

}
