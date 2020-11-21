package com.gsg.event.domain.model.event;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface EventState {
    String json() throws JsonProcessingException;
}
