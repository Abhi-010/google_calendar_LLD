package com.abhi.google_calendar.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionDto {
    private HttpStatus httpStatus ;
    private String message ;
}
