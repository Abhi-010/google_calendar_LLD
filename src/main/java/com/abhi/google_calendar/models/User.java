package com.abhi.google_calendar.models;

import java.util.List;

public class User extends BaseModel{
    private String name ;
    private String email ;
    private List<Event> invitation ;
    List<Appointment> appointments ;
}
