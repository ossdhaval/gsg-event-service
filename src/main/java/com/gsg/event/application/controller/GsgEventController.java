package com.gsg.event.application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gsg.event.application.EventApplicationService;
import com.gsg.event.domain.model.event.BirthdayEvent;
import com.gsg.event.domain.model.event.BirthdayEventState;
import com.gsg.event.domain.model.event.Event;
import com.gsg.event.domain.model.event.EventRepository;
import com.gsg.event.infrastructure.repository.event.BirthdayEventRepository;
import com.gsg.event.util.EventUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class GsgEventController
{

    @Autowired
    EventApplicationService eas;

    @ApiOperation("This API creates new event")
    @PostMapping("/api/event")
    public ResponseEntity<String> createEvent(@RequestBody BirthdayEventState newEventState){
        // happy path
            // call the service and it successfully creates events and gives you back the Event object
        BirthdayEvent newlyCreateEvent = eas.createNewEvent(newEventState);

        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(newlyCreateEvent.getEventState().json());
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }




        // exception path where service returns
            // invalid argument exceptions
            // various business constraint violation
                // event date set in past
                // event is more than 3 years away
                // maximum event limit reached for this organiser
                // An event by same organizer has been created on same date-time-location
                // etc
            // Internal app error
    }

    @ApiOperation("This API returns all events organized by a person")
    @GetMapping(value = "/api/event/{eventPersonId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Event> getEventforPerson(@PathVariable("eventPersonId") String eventPersonId)
    {
        Optional<Event> eventForPerson = eas.findEventByPerson(eventPersonId);
//        return eventForPerson.map(eventFound ->{
//            return ResponseEntity.ok().body(eventFound);
//        }).orElse(ResponseEntity.notFound().build());
        return new ArrayList<Event>();

    }

    @ApiOperation("This API returns event with a specific id")
    @GetMapping(value = "/api/event/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> getEventById(@PathVariable("id") String eventId)
    {
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation("This api allows updates to an event. Response will return updated version of event.")
    @PutMapping(value = "/api/event/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> updateEvent(@PathVariable("id") String eventId, @RequestBody Event eventUpdates)
    {
        return ResponseEntity.badRequest().build();
    }



    @ApiOperation("This API deletes an event. ")
    @DeleteMapping("/api/delete/{id}")
    public ResponseEntity deleteEvent(@PathVariable("id") String eventIdToBeDeleted)
    {
        return ResponseEntity.badRequest().build();
    }

}
