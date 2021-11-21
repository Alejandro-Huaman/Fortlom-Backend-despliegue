package upc.edu.pe.FortlomBackend.backend.resource.ForumComment;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateForumCommentResource {

    @NotNull
    private String ForumCommentDescription;

    @NotNull
    private String date;
}
