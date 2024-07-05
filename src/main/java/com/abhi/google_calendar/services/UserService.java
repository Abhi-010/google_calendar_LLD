package com.abhi.google_calendar.services;

import com.abhi.google_calendar.exception.NotFoundException;
import com.abhi.google_calendar.models.User;
import com.abhi.google_calendar.respository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository ;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository ;
    }

    public User createUser(String name, String email){
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        return userRepository.save(newUser);
    }

    public User getUserById(Long id) throws NotFoundException {
        Optional<User> optionalUser = userRepository.findById(id) ;

        if(optionalUser.isEmpty()){
            throw new NotFoundException("User is not present");
        }
        return optionalUser.get();
    }

    public List<User> getListOfUser(List<Long> ids) throws NotFoundException {

        List<User> userList = new ArrayList<>();
        for (Long id : ids) {
            userList.add(getUserById(id));
        }
        return userList ;
    }
}
