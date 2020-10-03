package com.gsg.event.domain.model.event;

import com.gsg.kernel.usermgmt.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;
import java.util.UUID;

@Entity
public class BirthdayEventState {
    @Id
    private UUID eventId;
    @Transient
    private List<UUID> eventWishlists;
    private UUID eventHostId;
    private EventDateTime eventDateTime;
    private String eventForPerson;
    private EventLocationAddress eventLocationAddress;
    private String eventLocationMapLink;



    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public List<UUID> getEventWishlists() {
        return eventWishlists;
    }

    public void setEventWishlists(List<UUID> eventWishlists) {
        this.eventWishlists = eventWishlists;
    }

    public UUID getEventHost() {
        return eventHostId;
    }

    public void setEventHost(User eventHost) {
        this.eventHostId = eventHost.getUserId()q;
    }

    public EventDateTime getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(EventDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String getEventForPerson() {
        return eventForPerson;
    }

    public void setEventForPerson(String eventForPerson) {
        this.eventForPerson = eventForPerson;
    }

    public EventLocationAddress getEventLocationAddress() {
        return eventLocationAddress;
    }

    public void setEventLocationAddress(EventLocationAddress eventLocationAddress) {
        this.eventLocationAddress = eventLocationAddress;
    }

    public String getEventLocationMapLink() {
        return eventLocationMapLink;
    }

    public void setEventLocationMapLink(String eventLocationMapLink) {
        this.eventLocationMapLink = eventLocationMapLink;
    }






}
