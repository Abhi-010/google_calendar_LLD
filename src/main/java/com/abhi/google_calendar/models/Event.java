package com.abhi.google_calendar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Event extends BaseModel{

    private LocalTime startTime ;
    private LocalTime endTime ;
    private LocalDate date ;
    private String title ;
    private String description;
    @ManyToOne
    private User organizer ;
    private String location ;

    @ManyToMany(mappedBy = "invitation")
    private List<User> invitedUser ;

    private EventStatus status ;

    public Event(){

    }

    public Event(EventBuilder eventBuilder){
        // copy all attributes and crate a Event object and return
        this.startTime = eventBuilder.getStartTime() ;
        this.endTime = eventBuilder.getEndTime();
        this.date = eventBuilder.getDate();
        this.title = eventBuilder.getTitle() ;
        this.description = eventBuilder.getDescription() ;
        this.location = eventBuilder.getLocation() ;
        this.organizer = eventBuilder.getOrganizer();
        this.status = eventBuilder.getStatus();
        this.invitedUser = new ArrayList<>();
        this.invitedUser.addAll(eventBuilder.invitedUser);
    }

    public static EventBuilder getBuilder(){
        return new EventBuilder() ;
    }

    public static class EventBuilder {
        private LocalTime startTime ;
        private LocalTime endTime ;
        private LocalDate date ;
        private String title ;
        private String description;
        private User organizer ;
        private String location ;
        private List<User> invitedUser ;
        private EventStatus status ;


        public Event build(){
            //validate things and create a Event object
            return  new Event(this);
        }

        public EventBuilder setStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public EventBuilder setEndTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }
        public EventBuilder setDate(LocalDate date){
            this.date = date ;
            return this ;
        }

        public EventBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public EventBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public EventBuilder setOrganizer(User organizer) {
            this.organizer = organizer;
            return this;
        }

        public EventBuilder setLocation(String location) {
            this.location = location;
            return this;
        }

        public EventBuilder setInvitedUser(List<User> invitedUser) {
            this.invitedUser = invitedUser;
            return this;
        }

        public EventBuilder setStatus(EventStatus status) {
            this.status = status;
            return this;
        }

        public LocalTime getStartTime() {
            return startTime;
        }

        public LocalDate getDate(){
            return date ;
        }

        public LocalTime getEndTime() {
            return endTime;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public User getOrganizer() {
            return organizer;
        }

        public String getLocation() {
            return location;
        }

        public EventStatus getStatus() {
            return status;
        }

        public List<User> getInvitedUser() {
            return invitedUser;
        }
    }
}
