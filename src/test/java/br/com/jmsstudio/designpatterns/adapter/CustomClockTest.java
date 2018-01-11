package br.com.jmsstudio.designpatterns.adapter;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class CustomClockTest {

    @Test
    public void shouldReturnTheCurremtDateAtStartOfDay() {
        LocalDateTime nowStartOfDay = LocalDate.now().atStartOfDay();

        assertEquals(nowStartOfDay, new CustomClock().todayBeginningOfDay());
    }

    @Test
    public void shouldReturnTheCurremtDateAtEndOfDay() {
        LocalDateTime nowEndOfDay = LocalDate.now().atTime(LocalTime.MAX);

        assertEquals(nowEndOfDay, new CustomClock().todayEndOfDay());
    }
}
