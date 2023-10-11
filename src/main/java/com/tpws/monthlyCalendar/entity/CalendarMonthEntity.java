package com.tpws.monthlyCalendar.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class CalendarMonthEntity {
    Date calendarDate;
    String event;
}
