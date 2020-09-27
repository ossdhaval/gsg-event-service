package com.gsg.event.domain.model.event;

import java.util.UUID;

public interface Event
{
    boolean reschedule(EventDateTime dateTime);
    boolean addWishlist(UUID wishlistUUID);
    boolean removeWishlist(UUID wishlistUUID);
}
