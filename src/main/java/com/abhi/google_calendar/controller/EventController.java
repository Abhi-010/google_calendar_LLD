package com.abhi.google_calendar.controller;

import com.abhi.google_calendar.dto.GenericEventDto;
import com.abhi.google_calendar.dto.RequestEventDto;
import com.abhi.google_calendar.dto.RequestEventParseDto;
import com.abhi.google_calendar.dto.UserResponseDto;
import com.abhi.google_calendar.exception.NotFoundException;
import com.abhi.google_calendar.models.Event;
import com.abhi.google_calendar.models.User;
import com.abhi.google_calendar.services.EventService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private EventService eventService ;
    public EventController(EventService eventService){
        this.eventService = eventService ;
    }

    //creat Event

    @PostMapping
    public GenericEventDto createEvent(@RequestBody RequestEventDto requestEventDto) throws NotFoundException {

        //need to parse the data and time
        RequestEventParseDto requestEventParseDto = new RequestEventParseDto();

        requestEventParseDto.setDate(LocalDate.parse(requestEventDto.getDate()));
        requestEventParseDto.setStartTime(LocalTime.parse(requestEventDto.getStartTime()));
        requestEventParseDto.setEndTime(LocalTime.parse(requestEventDto.getEndTime()));
        requestEventParseDto.setTitle(requestEventDto.getTitle());
        requestEventParseDto.setDescription(requestEventDto.getDescription());
        requestEventParseDto.setOrganizerid(requestEventDto.getOrganizerid());
        requestEventParseDto.setLocation(requestEventDto.getLocation());
        requestEventParseDto.setInvitedUserIds(requestEventDto.getInvitedUserIds());

        Event newEvent = eventService.createEvent(requestEventParseDto);

        GenericEventDto genericEventDto = new GenericEventDto() ;
        genericEventDto.setId(newEvent.getId());
        genericEventDto.setStartTime(newEvent.getStartTime());
        genericEventDto.setEndTime(newEvent.getEndTime());
        genericEventDto.setDate(newEvent.getDate());
        genericEventDto.setTitle(newEvent.getTitle());
        genericEventDto.setDescription(newEvent.getDescription());

        genericEventDto.setOrganizer(new UserResponseDto(newEvent.getOrganizer().getName(), newEvent.getOrganizer().getEmail()));
        genericEventDto.setLocation(newEvent.getLocation());

        List<UserResponseDto> userResponseDtoList = new ArrayList<>();

        for(User user : newEvent.getInvitedUser()){
            userResponseDtoList.add(new UserResponseDto(user.getName(),user.getEmail()));
        }
        genericEventDto.setInvitedUsers(userResponseDtoList);
        genericEventDto.setEventStatus(newEvent.getStatus());
        return genericEventDto ;
    }
}
