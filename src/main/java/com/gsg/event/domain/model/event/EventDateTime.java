package com.gsg.event.domain.model.event;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Embeddable
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
    public LocalTime getEventTime(){ return this.eventDateTime.toLocalTime();}
    public LocalDate getEventDate(){ return this.eventDateTime.toLocalDate();}

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }
}
