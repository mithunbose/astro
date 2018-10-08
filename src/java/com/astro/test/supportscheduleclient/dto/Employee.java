/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astro.test.supportscheduleclient.dto;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author mithbose
 */
public class Employee {

    private static final int dailyShiftCount = 2;

    public Employee() {
        this.employeeId = UUID.randomUUID().toString();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    String employeeId;

    int getFreeSlotForDate(final Date date) {
        // Lookup db fr empty slot
        return 0;
    }
    
    public void takeSlotForDate(final Date date, int shift) {
        // Persist false
    }

}