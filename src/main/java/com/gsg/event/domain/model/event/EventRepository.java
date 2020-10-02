package com.gsg.event.domain.model.event;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@EnableScan
public interface EventRepository extends CrudRepository<BirthdayEvent, UUID> {
}
