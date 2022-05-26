package com.gsg.event.util;

import com.gsg.event.domain.model.event.Address;
import com.gsg.event.domain.model.event.BirthdayEvent;
import com.gsg.event.domain.model.event.Event;
import com.gsg.event.domain.model.event.EventDateTime;
import com.gsg.kernel.usermgmt.User;
import com.gsg.kernel.usermgmt.EventUser;
import com.gsg.kernel.usermgmt.UserId;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

public class EventUtil {
    public static BirthdayEvent createFakeEvent(){
        return new BirthdayEvent.Builder(UUID.randomUUID())
                .withTitle("fakeevent1")
                .locationLink("fakelink1")
                .forPerson("fakedhaval1")
                .hostedBy(new EventUser(UserId.getNextId()))
                .atLocation(new Address.Builder().withName("fakeaddress1").build())
                .on(EventDateTime.setTo(LocalDateTime.now()))
                .withWishlists(Arrays.asList(UUID.randomUUID(),UUID.randomUUID()))
                .build();
    }

}
