package br.com.jmsstudio.designpatterns.adapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CustomClock {

    public LocalDate now() {
        return LocalDate.now();
    }

    public LocalDateTime todayBeginningOfDay() {
        return LocalDate.now().atStartOfDay();
    }

    public LocalDateTime todayEndOfDay() {
        return LocalDate.now().atTime(LocalTime.MAX);
    }

}
