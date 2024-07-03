package com.abhi.google_calendar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Appointment extends BaseModel{
    private Date startTime ;
    private Date endTime ;
    private String description ;
    @ManyToOne
    private User creator ;
}
