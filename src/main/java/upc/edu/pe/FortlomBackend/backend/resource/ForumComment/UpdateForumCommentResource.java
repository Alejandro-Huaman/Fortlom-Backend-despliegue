package upc.edu.pe.FortlomBackend.backend.resource.ForumComment;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class UpdateForumCommentResource {

    private Long id;

    @NotNull
    private String ForumCommentDescription;

    @NotNull
    private String date;
}