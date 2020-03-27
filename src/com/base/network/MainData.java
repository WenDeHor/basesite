package com.base.network;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainData {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Date date = new Date();
        System.out.println(date);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(date.getTime());
        System.out.println(date.getClass().getName());

        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        System.out.println(cal.getTime());
        System.out.println(cal.getClass().getName());
        System.out.println(cal.getTimeZone().getDisplayName());

        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        System.out.println(ldt);

        System.out.println();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        System.out.println(sdf.format(date));

        System.out.println();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        System.out.println(dtf.format(ldt));

    }
}
