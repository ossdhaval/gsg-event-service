package com.gsg.event.domain.model.event;

import java.time.LocalDateTime;
import java.util.Date;

public class EventDateTime {

    private LocalDateTime eventDateTime;

    private EventDateTime(){}

    public static EventDateTime setTo(LocalDateTime dt)
    {
        EventDateTime edt = new EventDateTime();
        edt.eventDateTime = dt;
        return edt;
    }

    public LocalDateTime getEventDateTime()
    {
        return eventDateTime;
    }
}
