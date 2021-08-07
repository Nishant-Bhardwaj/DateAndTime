package com.java8.datetime.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class DateTimeService {

    /**
     * LocalDate Services
     */

    public LocalDate getLocalDate() {
        return LocalDate.now();
    }

    public LocalDate getPreviousLocalDate(Long years, Long months, Long days){
        return LocalDate.now()
                .minusYears(years)
                .minusMonths(months)
                .minusDays(days);
    }

    public LocalDate getFutureLocalDate(Long years, Long months, Long days){
        return LocalDate.now()
                .plusYears(years)
                .plusMonths(months)
                .minusDays(days);
    }

    public DayOfWeek getDayOfWeek(LocalDate localDate){
        return localDate.getDayOfWeek();
    }

    /**
     * LocalTime
     */

    public LocalTime getLocalTime(){
        return LocalTime.now();
    }

    /**
     * LocalDateTime
     */

    public LocalDateTime getLocalDateTime(){
        return LocalDateTime.now();
    }
}
