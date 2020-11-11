package com.gsg.event.application;

import com.gsg.event.domain.model.event.Address;
import com.gsg.event.domain.model.event.BirthdayEvent;
import com.gsg.event.domain.model.event.EventDateTime;

import com.gsg.event.infrastructure.repository.event.BirthdayEventRepository;
import com.gsg.kernel.usermgmt.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EventApplicationService
{
    public BirthdayEvent createBirthdayEvent()
    {
        BirthdayEvent be = new BirthdayEvent.Builder(UUID.randomUUID())
                .hostedBy(new AppUser(UUID.randomUUID()))
                .forPerson("Dhaval")
                .atLocation(new Address())
                .on(EventDateTime.setTo(LocalDateTime.now()))
                .locationLink("this-is-a-link")
                .build();
        return be;
    }



}
