package com.abhi.google_calendar.dto;

import com.abhi.google_calendar.models.EventStatus;
import com.abhi.google_calendar.models.User;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class RequestEventDto {
    private String date ;
    private String startTime ;
    private String endTime ;
    private String title ;
    private String description;
    private Long organizerid ;
    private String location ;
    private List<Long> invitedUserIds ;
}
