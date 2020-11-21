package com.gsg.event.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsg.event.application.EventApplicationService;
import com.gsg.event.domain.model.event.Event;
import com.gsg.event.util.EventUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith({SpringExtension.class})
@SpringBootTest
@AutoConfigureMockMvc
public class GsgEventControllerTest
{
    @Autowired
    MockMvc mvcmock;

    @MockBean
    EventApplicationService mockEAS;

    @Test
    @DisplayName("GET /api/event/{id} On Success - return event")
    public void shouldReturnEventWhenFound() throws Exception {
        // setup the mock service
       // doReturn(true).when(mockEAS).createNewEvent();

        // call the api
        mvcmock.perform(get("/api/event/11111")).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id", is("11111")));
    }

    @Test
    @DisplayName("POST /api/event on success - return created entity")
    public void shouldReturnEventIfCreatedSuccessfully() throws Exception {
        Event fakeevent = EventUtil.createFakeEvent();
        System.out.println(fakeevent);
        System.out.println(new ObjectMapper().writeValueAsString(fakeevent.getEventState()));

        mvcmock.perform(post("/api/event")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(fakeevent.getEventState())))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.eventTitle", is("fakeevent1")));
    }

    @Test
    @DisplayName("GET /api/event/{eventPersonId} - return list of event")
    public void shouldReturnEventListForPersonWhenSuccess() throws Exception {

        // TODO : json path should ensure that there is one or more entries in the list. Handle scenario for zero events
        mvcmock.perform(get("/api/event/dummyorganizeruuid"))
                .andExpect(status().isFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is("33333")));
    }

    @Test
    @DisplayName("PUT /api/event/{id} on success - return updated event")
    public void shouldReturnUpdatedEventWhenSuccess() throws Exception {

        // create an event and persist into the db
        // then change one of the attribute of that event and

        Event updatedEvent = EventUtil.createFakeEvent();

        String content = new ObjectMapper().writeValueAsString(updatedEvent);

        mvcmock.perform(put("/api/event/11111")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(updatedEvent)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is("11111")));

    }


}
