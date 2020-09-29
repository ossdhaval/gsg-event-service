package com.gsg.event.infrastructure.repository.event;

import com.gsg.event.domain.model.event.Event;
import com.gsg.event.domain.model.event.EventRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface EventRepositoryImpl extends EventRepository, CrudRepository<Event, UUID>
{

}
