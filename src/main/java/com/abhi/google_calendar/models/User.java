package com.abhi.google_calendar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String name ;
    private String email ;

    @OneToMany
    private List<Event> invitation ;

    @OneToMany
    List<Appointment> appointments ;
}
