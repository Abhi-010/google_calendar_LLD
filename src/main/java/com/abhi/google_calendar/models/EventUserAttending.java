package com.abhi.google_calendar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EventUserAttending extends BaseModel{
    @OneToOne
    private Event event ;

    @OneToOne
    private User user ;
    private EventUserAttendingStatus status ;
}
