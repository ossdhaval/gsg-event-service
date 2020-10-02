package com.gsg.event.domain.model.event;

import com.gsg.kernel.AbstractId;


import java.util.UUID;

public class EventId extends AbstractId {
    private EventId()
    {
        super();
    }

    static EventId getNextId(){return new EventId();}

    public UUID id(){ return id;}
}
