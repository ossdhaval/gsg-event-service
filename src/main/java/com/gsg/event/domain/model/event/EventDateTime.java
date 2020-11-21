package com.gsg.event.domain.model.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Embeddable
public class EventDateTime {

//    @JsonProperty(value = "DateAndTime")
//    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
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
//    public LocalTime getEventTime(){ return this.eventDateTime.toLocalTime();}
//    public LocalDate getEventDate(){ return this.eventDateTime.toLocalDate();}

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }
}
