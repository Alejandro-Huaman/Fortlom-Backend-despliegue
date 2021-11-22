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
@Table(name = "Usuario")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(unique = true)
    private String Name;

    @NotNull
    @NotBlank
    @Size(max = 40)
    @Column(unique = true)
    private String LastName;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String Email;

    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column()
    private String Password;

    @OneToMany(targetEntity = Comment.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userid",referencedColumnName = "id")
    private List<Comment> comment;

    @OneToMany(targetEntity = Forum.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userid",referencedColumnName = "id")
    private List<Forum> forums;

    @OneToMany(targetEntity = ForumComment.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userid",referencedColumnName = "id")
    private List<ForumComment> forumComments;


    @OneToMany(targetEntity = Report.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userMainid",referencedColumnName = "id")
    private List<Report> reportmains;

    @OneToMany(targetEntity = Report.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userReportedid",referencedColumnName = "id")
    private List<Report> reporttouser;


}
