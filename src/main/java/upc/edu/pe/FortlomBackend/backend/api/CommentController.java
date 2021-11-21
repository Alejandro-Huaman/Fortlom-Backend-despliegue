package upc.edu.pe.FortlomBackend.backend.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Comment;
import upc.edu.pe.FortlomBackend.backend.domain.service.CommentService;
import upc.edu.pe.FortlomBackend.backend.mapping.CommentMapper;
import upc.edu.pe.FortlomBackend.backend.resource.Comment.CommentResource;
import upc.edu.pe.FortlomBackend.backend.resource.Comment.UpdateCommentResource;
import upc.edu.pe.FortlomBackend.backend.resource.Comment.CreateCommentResource;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentMapper mapper;

    @Autowired
    private ModelMapper mapping;

    @GetMapping("/comments")
    public Page<CommentResource> getAllComments(Pageable pageable) {
        return mapper.modelListToPage(commentService.getAll(), pageable);
    }

    @GetMapping("/comments/{commentId}")
    public CommentResource getCommentById(@PathVariable("commentId") Long commentId) {
        return mapper.toResource(commentService.getById(commentId));
    }

    @PostMapping("/users/{userId}/publications/{publicationId}/comments")
    public CommentResource createComment(@PathVariable Long userId, @PathVariable Long publicationId, @RequestBody CreateCommentResource request) {
        Comment comment = mapping.map(request, Comment.class);
        return mapping.map(commentService.create(userId, publicationId, comment), CommentResource.class);
    }

    @GetMapping("/publications/{publicationId}/comments")
    public Page<CommentResource> getAllCommentsByPublicationId(@PathVariable Long publicationId,Pageable pageable) {
        return mapper.modelListToPage(commentService.getCommentByPublicationId(publicationId), pageable);
    }

    @PutMapping("/comments/{commentId}")
    public CommentResource updateComment(@PathVariable Long commentId, @RequestBody UpdateCommentResource request) {
        return mapper.toResource(commentService.update(commentId, mapper.toModel(request)));
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
        return commentService.delete(commentId);
    }
}
