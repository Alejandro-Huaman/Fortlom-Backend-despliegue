package upc.edu.pe.FortlomBackend.backend.resource.Comment;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateCommentResource {
    @NotNull
    @Size(max = 150)
    private String CommentDescription;
    @NotNull
    @Size(max = 50)
    private String date;
}
