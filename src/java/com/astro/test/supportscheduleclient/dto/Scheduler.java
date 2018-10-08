package com.astro.test.supportscheduleclient.dto;

import java.util.Date;
import java.util.TimerTask;

/**
 *
 * @author mithbose
 */
public class Scheduler extends TimerTask {

    @Override
    public void run() {
        // TODO: write code to create schedule for next 1 day and perist in db
        // change db schema
    }

    /**
     * Creates schedule and persists in db for the # days parameter
     *
     * @param days
     */
    public void createSchedule(int days, Date startDate) {
        /* 
generating a schedule that shows who’s turn is it to support
    
repeat selecting two engineers at random to both complete 
a half day of support (shift) each to ultimately generate a schedule 
that shows whose turn is it to support the business.


Rules
An engineer can do at most one half day shift in a day.
An engineer cannot have half day shifts on consecutive days.
Each engineer should have completed one whole day of support in any 2 week period.

// initially create 2 weeks then on 1 week gap.
         */

        for (int i = 0; i < days; i++) {

        }

    }

}
