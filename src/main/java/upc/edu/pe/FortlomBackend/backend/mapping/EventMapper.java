package upc.edu.pe.FortlomBackend.backend.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Event;
import upc.edu.pe.FortlomBackend.backend.resource.Event.EventResource;
import upc.edu.pe.FortlomBackend.backend.resource.Event.CreateEventResource;
import upc.edu.pe.FortlomBackend.backend.resource.Event.UpdateEventResource;
import upc.edu.pe.FortlomBackend.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class EventMapper implements Serializable{

    @Autowired
    EnhancedModelMapper mapper;

    public EventResource toResource(Event model) {
        return mapper.map(model, EventResource.class);
    }

    public Page<EventResource> modelListToPage(List<Event> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, EventResource.class), pageable, modelList.size());
    }

    public Event toModel(CreateEventResource resource) {
        return mapper.map(resource, Event.class);
    }

    public Event toModel(UpdateEventResource resource) {
        return mapper.map(resource, Event.class);
    }

}
