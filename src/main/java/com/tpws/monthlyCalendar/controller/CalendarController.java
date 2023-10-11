package com.tpws.monthlyCalendar.controller;

import com.tpws.monthlyCalendar.entity.CalendarDto;
import com.tpws.monthlyCalendar.entity.CalendarMonthEntity;
import org.example.Calendar;
import org.example.CalendarEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("calendar")
public class CalendarController {

    private Calendar calendar = new Calendar();


    @PostMapping("monthly-calendar")
    public ResponseEntity<List<CalendarEntity>> getMonthlCalendar(@RequestBody CalendarDto calendarDto) {
        List<CalendarEntity> monthCalendar = this.calendar.getMonthCalendar(calendarDto.getMonth(), calendarDto.getYear());
        return new ResponseEntity<>(monthCalendar, HttpStatus.OK);
    }

    @PostMapping("monthly-calendar-with-event")
    public ResponseEntity<List<CalendarMonthEntity>> generateCalendarWithEvent(@RequestBody CalendarMonthEntity calendarMonthEntity) {
        List<CalendarEntity> calendarEntities = this.calendar.generateEventMonthCalendar(calendarMonthEntity.getCalendarDate(), calendarMonthEntity.getEvent());
        List<CalendarMonthEntity> calendarMonthEntities = new ArrayList<>();
        for (CalendarEntity calendarEntity: calendarEntities) {
            CalendarMonthEntity calendarMonthEntityWithEvent = new CalendarMonthEntity();
            calendarMonthEntityWithEvent.setCalendarDate(calendarEntity.getCalendarDate());
            calendarMonthEntityWithEvent.setEvent(calendarEntity.getEvent());
            calendarMonthEntities.add(calendarMonthEntityWithEvent);
        }
        return new ResponseEntity<>(calendarMonthEntities, HttpStatus.OK);
    }

}
