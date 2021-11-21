package upc.edu.pe.FortlomBackend.backend.mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Comment;
import upc.edu.pe.FortlomBackend.backend.resource.Comment.CommentResource;
import upc.edu.pe.FortlomBackend.backend.resource.Comment.CreateCommentResource;
import upc.edu.pe.FortlomBackend.backend.resource.Comment.UpdateCommentResource;
import upc.edu.pe.FortlomBackend.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class CommentMapper implements  Serializable{

    @Autowired
    EnhancedModelMapper mapper;

    public CommentResource toResource(Comment model) {
        return mapper.map(model, CommentResource.class);
    }

    public Page<CommentResource> modelListToPage(List<Comment> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, CommentResource.class), pageable, modelList.size());
    }
    public Comment toModel(CreateCommentResource resource) {
        return mapper.map(resource, Comment.class);
    }

    public Comment toModel(UpdateCommentResource resource) {
        return mapper.map(resource, Comment.class);
    }

}