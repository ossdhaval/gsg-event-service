package com.gsg.event.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
public class GsgEventController
{
    @GetMapping("/mylogin")
    public String sayHello()
    {
        return "mylogin";
    }
}
