package upc.edu.pe.FortlomBackend.backend.resource.Comment;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
public class UpdateCommentResource {

    private Long id;
    @NotNull
    private String CommentDescription;
    @NotNull
    private String date;
}
