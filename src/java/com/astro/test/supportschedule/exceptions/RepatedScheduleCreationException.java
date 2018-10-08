package com.astro.test.supportschedule.exceptions;

public class RepatedScheduleCreationException extends Exception {

    public RepatedScheduleCreationException(final Exception e) {
        super(e);
    }

    public RepatedScheduleCreationException(final String s) {
        super(s);
    }
}
