package com.github.jerkjerky.census.eventstreaming.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.jerkjerky.census.eventstreaming.models.service.BasicCensusEvent;

public class CensusEventMapper {

    private final ObjectMapper objectMapper;

    public CensusEventMapper(){
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    public BasicCensusEvent convertMessage(String eventMessage) throws JsonProcessingException {
        return objectMapper.readValue(eventMessage, BasicCensusEvent.class);
    }
}
