package upc.edu.pe.FortlomBackend.backend.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.ForumComment;
import upc.edu.pe.FortlomBackend.backend.domain.service.ForumCommentService;
import upc.edu.pe.FortlomBackend.backend.mapping.ForumCommentMapper;
import upc.edu.pe.FortlomBackend.backend.resource.ForumComment.ForumCommentResource;
import upc.edu.pe.FortlomBackend.backend.resource.ForumComment.UpdateForumCommentResource;
import upc.edu.pe.FortlomBackend.backend.resource.ForumComment.CreateForumCommentResource;

@RestController
@RequestMapping("/api/v1")
public class ForumCommentController {
    @Autowired
    private ForumCommentService forumcommentService;

    @Autowired
    private ForumCommentMapper mapper;

    @Autowired
    private ModelMapper mapping;

    @GetMapping("/forumcomments")
    public Page<ForumCommentResource> getAllForumComments(Pageable pageable) {
        return mapper.modelListToPage(forumcommentService.getAll(), pageable);
    }

    @GetMapping("/forumcomments/{forumcommentId}")
    public ForumCommentResource getForumCommentById(@PathVariable("forumcommentId") Long forumcommentId) {
        return mapper.toResource(forumcommentService.getById(forumcommentId));
    }

    @PostMapping("/users/{userId}/forums/{forumId}/forumcomments")
    public ForumCommentResource createForumComment(@PathVariable Long userId, @PathVariable Long forumId, @RequestBody CreateForumCommentResource request) {
        ForumComment forumcomment = mapping.map(request, ForumComment.class);
        return mapping.map(forumcommentService.create(userId, forumId, forumcomment), ForumCommentResource.class);
    }

    @GetMapping("/forums/{forumId}/forumcomments")
    public Page<ForumCommentResource> getAllForumCommentsByForumId(@PathVariable Long forumId,Pageable pageable) {
        return mapper.modelListToPage(forumcommentService.getForumCommentByForumId(forumId), pageable);
    }

    @PutMapping("/forumcomments/{forumcommentId}")
    public ForumCommentResource updateForumComment(@PathVariable Long forumcommentId, @RequestBody UpdateForumCommentResource request) {
        return mapper.toResource(forumcommentService.update(forumcommentId, mapper.toModel(request)));
    }

    @DeleteMapping("/forumcomments/{forumcommentId}")
    public ResponseEntity<?> deleteForumComment(@PathVariable Long forumcommentId) {
        return forumcommentService.delete(forumcommentId);
    }
}
