package com.java8.datetime.controller;

import com.java8.datetime.service.DateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;

@RestController
public class DateController {

    @Autowired
    DateTimeService dateTimeService;

    @RequestMapping("/getLocalDate")
    public LocalDate getLocalDate(){
        return dateTimeService.getLocalDate();
    }

    @RequestMapping("/getPreviousLocalDate/{years}/{months}/{days}")
    public LocalDate getPreviousLocalDate(@PathVariable("years") Long years,
                                  @PathVariable("months") Long months,
                                  @PathVariable("days") Long days){

        return dateTimeService.getPreviousLocalDate(years, months, days);
    }

    @RequestMapping("/getFutureLocalDate/{years}/{months}/{days}")
    public LocalDate getFutureLocalDate(@PathVariable("years") Long years,
                                  @PathVariable("months") Long months,
                                  @PathVariable("days") Long days){

        return dateTimeService.getFutureLocalDate(years, months, days);
    }

    @RequestMapping("/getDayOfWeek/{localDate}")
    public DayOfWeek getDayOfWeek(@PathVariable("localDate") String date){
        LocalDate localDate = LocalDate.parse(date);
        return dateTimeService.getDayOfWeek(localDate);
    }
}
