package com.gsg.event.application;

import com.gsg.event.domain.model.event.BirthdayEvent;
import com.gsg.event.domain.model.event.BirthdayEventState;
import com.gsg.event.domain.model.event.Event;
import com.gsg.event.infrastructure.repository.event.BirthdayEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventApplicationService
{
    @Autowired
    BirthdayEventRepository er;

    public BirthdayEvent createNewEvent(BirthdayEventState unSavedEventState)
    {
        BirthdayEventState savedEventState = er.save(unSavedEventState);
        return new BirthdayEvent(savedEventState);
    }

    public Optional<Event> findEventByPerson(String personName)
    {
        Optional<BirthdayEventState> bes = er.findByEventForPerson(personName);
        return bes.isPresent()?Optional.of(new BirthdayEvent(bes.get())):Optional.empty();
    }

    /**
     *
     * @param list of event UUIDs
     * @return list of events found for UUIDs in input list
     */
    public List<BirthdayEventState> findEventByEventIds(String eventUUID)
    {

        List<UUID> uuidList = Arrays.asList(UUID.fromString(eventUUID));
        List<BirthdayEventState> returnedEvents = new ArrayList<>();
        er.findAllById(uuidList).forEach(returnedEvents::add);
        return returnedEvents;

    }
}
