package com.gsg.event.domain.model.event;

import com.gsg.kernel.usermgmt.User;
import com.gsg.event.domain.model.invite.InviteManager;

import java.util.List;
import java.util.UUID;

public abstract class AbstractEvent implements Event{
    private UUID eventId;
    private List<UUID> eventWishlists;
    private User eventHost;
    private EventDateTime eventDateTime;
    private String eventForPerson;
    private Address eventLocationAddress;
    private String eventLocationMapLink;
    private InviteManager inviteManager;

    private void initializeInviteManager()
    {

    }
}
