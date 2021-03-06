package com.gsg.event.domain.model.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsg.event.infrastructure.repository.event.BirthdayEventRepository;
import com.gsg.kernel.usermgmt.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class BirthdayEvent extends AbstractEvent
{
    private BirthdayEventState state;

    @Autowired
    private BirthdayEventRepository stateRepository;

    public BirthdayEvent(BirthdayEventState state)
    {
        this.state = state;
    }

    @Override
    public boolean reschedule(EventDateTime dateTime) {
        return false;
    }

    @Override
    public boolean addWishlist(UUID wishlistUUID) {
        return false;
    }

    @Override
    public boolean removeWishlist(UUID wishlistUUID) {
        return false;
    }

    @Override
    public BirthdayEventState getEventState(){ return state;}

    public static class Builder{
        private BirthdayEventState bes = new BirthdayEventState();
        private BirthdayEvent be = new BirthdayEvent(bes);

        public Builder(UUID eventId)
        {
            be.state.setEventId(eventId);
            be.state.setEventType(EventType.BIRTHDAY);

        }
        public Builder withTitle(String title) { be.state.setEventTitle(title); return this;}
        public Builder withWishlists(List<UUID> wishlists){ be.state.setEventWishlists(wishlists); return this; }
        public Builder hostedBy(User eventhost){ be.state.setEventHostId(eventhost); return this;}
        public Builder on(EventDateTime eventDT){ be.state.setEventDateTime(eventDT); return this;}
        public Builder forPerson(String eventforperson){ be.state.setEventForPerson(eventforperson); return this;}
        public Builder atLocation(Address location){ be.state.setEventLocationAddress(location); return this;}
        public Builder locationLink(String link){ be.state.setEventLocationMapLink(link); return this; }
        public BirthdayEvent build(){ return be;}
    }

    @Override
    public String toString()
    {
        String jsonString="";
        try {
            jsonString = new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
