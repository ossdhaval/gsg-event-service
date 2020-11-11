package com.gsg.event.infrastructure.repository.event;

import com.gsg.event.domain.model.event.BirthdayEventState;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Qualifier("BirthdayRepository")
public interface BirthdayEventRepository extends CrudRepository<BirthdayEventState, UUID>
{
    
}
