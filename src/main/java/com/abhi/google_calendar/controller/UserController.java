package com.abhi.google_calendar.controller;

import com.abhi.google_calendar.dto.GenericUserDto;
import com.abhi.google_calendar.dto.RequestUserDto;
import com.abhi.google_calendar.exception.NotFoundException;
import com.abhi.google_calendar.models.User;
import com.abhi.google_calendar.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService ;
    public UserController(UserService userService){
        this.userService = userService ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericUserDto> getUserById(@PathVariable ("id") Long id) throws NotFoundException {
        User user = userService.getUserById(id) ;
        GenericUserDto genericUserDto = new GenericUserDto();
        genericUserDto.setId(user.getId());
        genericUserDto.setName(user.getName());
        genericUserDto.setEmail(user.getEmail());

        return new ResponseEntity<>(genericUserDto, HttpStatus.FOUND) ;
    }

    @PostMapping
    public GenericUserDto createUser(@RequestBody RequestUserDto requestUserDto){
        User user = userService.createUser(requestUserDto.getName(), requestUserDto.getEmail()) ;
        GenericUserDto genericUserDto = new GenericUserDto();
        genericUserDto.setId(user.getId());
        genericUserDto.setName(user.getName());
        genericUserDto.setEmail(user.getEmail());
        return genericUserDto;
    }
}
