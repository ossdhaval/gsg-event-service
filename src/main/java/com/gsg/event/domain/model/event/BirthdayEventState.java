package com.gsg.event.domain.model.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsg.kernel.usermgmt.User;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class BirthdayEventState implements EventState{
    @Id
    private UUID eventId;

    private Event.EventType eventType;
    private String eventTitle;
    @Transient
    private List<UUID> eventWishlists;
    @JsonIgnore
    private UUID eventHostId;
    @Embedded
    @JsonIgnore
    private EventDateTime eventDateTime;
    private String eventForPerson;
    @Embedded
    private Address eventLocationAddress;
    private String eventLocationMapLink;

    public BirthdayEventState(){}

    public String getEventTitle() { return eventTitle; }

    public void setEventTitle(String title){ this.eventTitle = title;}

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

    public UUID getEventHostId() {
        return eventHostId;
    }

    public void setEventHostId(User eventHost) {
        this.eventHostId = eventHost.getUserId();
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

    public Address getEventLocationAddress() {
        return eventLocationAddress;
    }

    public void setEventLocationAddress(Address eventLocationAddress) {
        this.eventLocationAddress = eventLocationAddress;
    }

    public String getEventLocationMapLink() {
        return eventLocationMapLink;
    }

    public void setEventLocationMapLink(String eventLocationMapLink) {
        this.eventLocationMapLink = eventLocationMapLink;
    }

    public Event.EventType getEventType() {
        return eventType;
    }

    public void setEventType(Event.EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String json() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }


}
