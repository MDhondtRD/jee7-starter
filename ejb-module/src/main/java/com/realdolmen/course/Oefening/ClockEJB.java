package com.realdolmen.course.Oefening;

import javax.ejb.*;

@Singleton
public class ClockEJB {

    private int count = 0;

    @Schedule(second = "*", minute = "*", hour = "*", persistent = false)
    public void printTime(Timer timer){
        System.out.println(System.currentTimeMillis());
        if (++count >= 10)
            timer.cancel();
    }

}
