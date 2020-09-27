package com.gsg.event.domain.model.event;

import com.gsg.kernel.usermgmt.User;
import com.gsg.event.domain.model.invite.InviteManager;

import java.util.List;
import java.util.UUID;

public class AbstractEvent {
    private UUID eventId;
    private List<UUID> eventWishlists;
    private User eventHost;
    private EventDateTime eventDateTime;
    private String eventForPerson;
    private EventLocationAddress eventLocationAddress;
    private String eventLocationMapLink;
    private InviteManager inviteManager;
}
