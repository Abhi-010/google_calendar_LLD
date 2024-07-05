package com.abhi.google_calendar.services;

import com.abhi.google_calendar.dto.RequestEventDto;
import com.abhi.google_calendar.dto.RequestEventParseDto;
import com.abhi.google_calendar.exception.NotFoundException;
import com.abhi.google_calendar.models.Event;
import com.abhi.google_calendar.models.EventStatus;
import com.abhi.google_calendar.models.User;
import com.abhi.google_calendar.respository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private EventRepository eventRepository ;
    private UserService userService ;
    public EventService(EventRepository eventRepository,UserService userService){
        this.eventRepository = eventRepository ;
        this.userService = userService ;
    }

    public Event createEvent(RequestEventParseDto requestEventParseDto) throws NotFoundException {

        List<User> invitedUserList = userService.getListOfUser(requestEventParseDto.getInvitedUserIds());

        User organizer = userService.getUserById(requestEventParseDto.getOrganizerid());

        Event newEvent = Event.getBuilder()
                .setStartTime(requestEventParseDto.getStartTime())
                .setEndTime(requestEventParseDto.getEndTime())
                .setDate(requestEventParseDto.getDate())
                .setTitle(requestEventParseDto.getTitle())
                .setDescription(requestEventParseDto.getDescription())
                .setOrganizer(organizer)
                .setLocation(requestEventParseDto.getLocation())
                .setInvitedUser(invitedUserList).build();

        newEvent.setStatus(EventStatus.SCHEDULED);

        return eventRepository.save(newEvent);
    }

}
