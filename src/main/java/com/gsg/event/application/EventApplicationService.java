package com.gsg.event.application;

import com.gsg.event.domain.model.event.*;

import com.gsg.event.infrastructure.repository.event.BirthdayEventRepository;
import com.gsg.event.util.EventUtil;
import com.gsg.kernel.usermgmt.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

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


}
