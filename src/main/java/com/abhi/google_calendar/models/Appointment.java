package com.abhi.google_calendar.models;

import java.util.Date;

public class Appointment extends BaseModel{
    private Date startTime ;
    private Date endTime ;
    private String description ;
    private User creator ;
}
