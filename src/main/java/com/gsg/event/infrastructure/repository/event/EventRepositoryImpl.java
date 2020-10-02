package com.gsg.event.infrastructure.repository.event;

import com.gsg.event.domain.model.event.Event;
import com.gsg.event.domain.model.event.EventRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@EnableScan
public interface EventRepositoryImpl
{

}
