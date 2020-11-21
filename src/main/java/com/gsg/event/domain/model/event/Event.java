package com.gsg.event.domain.model.event;

import com.gsg.event.infrastructure.repository.event.BirthdayEventRepository;

import java.util.UUID;

public interface Event
{
    enum EventType {BIRTHDAY, MARRIAGE};
    boolean reschedule(EventDateTime dateTime);
    boolean addWishlist(UUID wishlistUUID);
    boolean removeWishlist(UUID wishlistUUID);
    BirthdayEventState getEventState();
}
