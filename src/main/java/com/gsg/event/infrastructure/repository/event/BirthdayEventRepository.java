package com.gsg.event.infrastructure.repository.event;

import com.gsg.event.domain.model.event.BirthdayEventState;
import com.gsg.event.domain.model.event.Event;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@Qualifier("BirthdayRepository")
public interface BirthdayEventRepository extends CrudRepository<BirthdayEventState, UUID>
{
    Optional<BirthdayEventState> findByEventForPerson(String name);

    Long deleteByEventForPerson(String name);
}
