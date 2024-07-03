package com.abhi.google_calendar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany
    private List<Event> invitation ;

    @OneToMany(mappedBy = "creator")
    List<Appointment> appointments ;
}
