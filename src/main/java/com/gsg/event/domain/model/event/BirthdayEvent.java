package com.gsg.event.domain.model.event;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.gsg.kernel.usermgmt.UserId;

import java.util.UUID;

@DynamoDBTable(tableName = "gsg-event")
public class BirthdayEvent extends AbstractEvent
{
    public BirthdayEvent(UserId eventHost, String eventForPerson) {
        super(eventHost, eventForPerson);
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

    @DynamoDBHashKey
    public UUID getUUID()
    {
        return this.eventId.id();
    }
}
