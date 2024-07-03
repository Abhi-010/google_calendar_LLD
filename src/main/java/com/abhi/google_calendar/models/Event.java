package com.abhi.google_calendar.models;

import java.util.Date;
import java.util.List;

public class Event extends BaseModel{
    private Date startTime ;
    private Date endtime ;
    private String title ;
    private String description;
    private User organizer ;
    private String location ;
    private List<User> invitedUser ;
    private EventStatus status ;
}
