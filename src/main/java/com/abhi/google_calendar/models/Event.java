package com.abhi.google_calendar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
public class Event extends BaseModel{

    private Date startTime ;
    private Date endTime ;
    private String title ;
    private String description;
    @ManyToOne
    private User organizer ;
    private String location ;

    @ManyToMany
    private List<User> invitedUser ;
    private EventStatus status ;

    public Event(){

    }

    public Event(EventBuilder eventBuilder){
        // copy all attributes and crate a Event object and return
        this.startTime = eventBuilder.getStartTime() ;
        this.endTime = eventBuilder.getEndTime();
        this.description = eventBuilder.getDescription() ;
        this.title = eventBuilder.getTitle() ;
        this.location = eventBuilder.getLocation() ;
        this.organizer = eventBuilder.getOrganizer();
        this.status = eventBuilder.getStatus();

        this.invitedUser = new ArrayList<>();
        this.invitedUser.addAll(eventBuilder.invitedUser);
    }

    public static EventBuilder Builder(){
        return new EventBuilder() ;
    }

    public static class EventBuilder {
        private Date startTime ;
        private Date endTime ;
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

        public EventBuilder setStartTime(Date startTime) {
            this.startTime = startTime;
            return this;
        }

        public EventBuilder setEndTime(Date endTime) {
            this.endTime = endTime;
            return this;
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

        public Date getStartTime() {
            return startTime;
        }

        public Date getEndTime() {
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
