package com.gsg.event.domain.model.event;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.gsg.kernel.usermgmt.UserId;

import java.util.UUID;


public interface Event
{

    boolean reschedule(EventDateTime dateTime);
    boolean addWishlist(UUID wishlistUUID);
    boolean removeWishlist(UUID wishlistUUID);


    UUID getUUID();

    UserId getEventHost();

    String getEventForPerson();


}
