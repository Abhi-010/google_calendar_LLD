package com.abhi.google_calendar.dto;

import com.abhi.google_calendar.models.EventStatus;
import com.abhi.google_calendar.models.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class GenericEventDto {
    private Long id ;
    private LocalTime startTime ;
    private LocalTime endTime ;
    private LocalDate date ;
    private String title ;
    private String description;
    private UserResponseDto organizer ;
    private String location ;
    private List<UserResponseDto> invitedUsers ;
    private EventStatus eventStatus ;
}
