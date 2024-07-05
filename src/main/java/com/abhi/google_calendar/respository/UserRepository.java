package com.abhi.google_calendar.respository;

import com.abhi.google_calendar.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
