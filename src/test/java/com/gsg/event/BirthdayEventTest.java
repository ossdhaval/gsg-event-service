package com.gsg.event;

import com.gsg.event.domain.model.event.Address;
import com.gsg.event.domain.model.event.BirthdayEvent;
import com.gsg.event.domain.model.event.EventDateTime;
import com.gsg.event.infrastructure.repository.event.BirthdayEventRepository;
import com.gsg.kernel.usermgmt.AppUser;
import com.gsg.kernel.usermgmt.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@SpringBootTest
public class BirthdayEventTest {

    @Autowired
    BirthdayEventRepository birthdayRepo;

    @Test
    public void shouldCreateBirthdayEvent()
    {
        BirthdayEvent be = new BirthdayEvent.Builder(UUID.randomUUID())
                .withTitle("fakeevent1")
                .locationLink("fakelink1")
                .forPerson("fakedhaval1")
                .hostedBy(new AppUser(UUID.randomUUID()))
                .atLocation(new Address.Builder().withName("fakeaddress1").build())
                .on(EventDateTime.setTo(LocalDateTime.now()))
                .withWishlists(Arrays.asList(UUID.randomUUID(),UUID.randomUUID()))
                .build();

        birthdayRepo.save(be.getEventState());
    }

}
