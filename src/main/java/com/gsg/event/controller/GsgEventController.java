package com.gsg.event.controller;

import com.gsg.event.domain.model.event.Event;
import com.gsg.event.domain.model.event.EventRepository;
import com.gsg.event.infrastructure.repository.event.BirthdayEventRepository;
import com.gsg.event.util.EventUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
public class GsgEventController
{
    @Autowired
    BirthdayEventRepository er;

    @ApiOperation("This API creates new events")
    @GetMapping("/api/event")qqqq
    public String createEvent(){
        er.save(EventUtil.createFakeEvent().getEventState());



        return "event created";
    }

    @ApiOperation("This API returns a single event")
    @GetMapping(value = "/api/event/{eventId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> getEvent(@PathVariable("eventId") int eventId)
    {
        System.out.println(">>>DDD : here");
        return new ResponseEntity<Event>(EventUtil.createFakeEvent(), HttpStatus.OK);
    }

    //TODO : implement logout functionality



//    @GetMapping("/loggedout")
//    public String saybye(){ return "Bye";}
}
