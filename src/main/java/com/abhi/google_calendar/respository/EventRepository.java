package com.abhi.google_calendar.respository;

import com.abhi.google_calendar.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
