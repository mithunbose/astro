/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astro.test.supportschedule.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 *
 * @author mithbose
 */
public final class DateUtils {

    private DateUtils() {
    }

    /**
     * Gets next monday as date object
     * @return Date : Date of next monday
     * @throws ParseException 
     */
    public static Date getNextMonday() throws ParseException {
        LocalDateTime localDate = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        return new SimpleDateFormat("yyyy-MM-dd").parse(localDate.toString());
    }

}
