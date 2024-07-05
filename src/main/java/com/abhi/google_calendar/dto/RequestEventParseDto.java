package com.abhi.google_calendar.dto;

import com.abhi.google_calendar.models.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Getter
@Setter
public class RequestEventParseDto {
    private LocalDate date ;
    private LocalTime startTime ;
    private LocalTime endTime ;
    private String title ;
    private String description;
    private Long organizerid ;
    private String location ;
    private List<Long> invitedUserIds ;
}
