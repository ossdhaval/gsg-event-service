package com.gsg.event.domain.model.event;

import java.util.UUID;

public class BirthdayEvent extends AbstractEvent
{
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
}
