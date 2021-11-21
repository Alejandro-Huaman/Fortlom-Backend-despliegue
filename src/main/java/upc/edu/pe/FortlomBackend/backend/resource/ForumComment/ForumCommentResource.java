package upc.edu.pe.FortlomBackend.backend.resource.ForumComment;

import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.FortlomBackend.backend.resource.UserResource;
import upc.edu.pe.FortlomBackend.backend.resource.Forum.ForumResource;

import java.util.Date;

@Getter
@Setter
public class ForumCommentResource {
    private Long id;
    private String ForumCommentDescription;
    private String date;
    private UserResource user;
    private ForumResource forum;
}