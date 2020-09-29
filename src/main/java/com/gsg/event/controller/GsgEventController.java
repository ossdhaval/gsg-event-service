package com.gsg.event.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GsgEventController
{
    @RequestMapping("/")
    public String sayHello()
    {
        return "Hello";
    }


}
