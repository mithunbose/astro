package com.astro.test.supportscheduleclient.dto;

import com.astro.test.supportschedule.exceptions.RepatedScheduleCreationException;
import com.astro.test.supportschedule.utils.DateUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mithbose
 */
public class Company {

    private Scheduler scheduler;

    // TODO: move this to configuration file
    private static final int EMPLOYEE_COUNT = 10;
    private static final int SCHEDULE_UPDATE_DURATION_DAYS = 1;
    // Assumption: weekends are working and need a proper schedule
    private static final int INITIAL_SCHEDULE_DURATION_DAYS = 14;

    private static HashMap<String, Employee> employeePool;

    public Company() {
        try {
            initCompany();
        } catch (final SQLException | RepatedScheduleCreationException ex) {
            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initCompany() throws SQLException, RepatedScheduleCreationException {
        employeePool = new HashMap<>();
        scheduler = new Scheduler();
        // Following methods are for demo puposes only.
        // In real world, assume the db to be already created and no need for
        // clearDb and  createEmployees methods
        clearDb();
        createEmployees();
        createSchedules();
    }

    private void createEmployees() throws SQLException {
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            Employee employee = new Employee();
            addEmployee(employee);
        }
    }

    public void addEmployee(final Employee employee) throws SQLException {
        // TODO: refactor thiss method with coding standards
        employeePool.put(employee.getEmployeeId(), employee);
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Company", "company", "mithbose");
        PreparedStatement stmt = con.prepareStatement("insert into employee (employeeid, date, firstshift, secondshift) values (?,?,?,?)");
        stmt.setString(1, employee.getEmployeeId());
        stmt.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        stmt.setBoolean(3, true);
        stmt.setBoolean(4, true);
        stmt.execute();

    }

    private static void clearDb() throws SQLException {
        // TODO: refactor thiss method with coding standards
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Company", "company", "mithbose");
        PreparedStatement stmt = con.prepareStatement("DELETE FROM EMPLOYEE");
        stmt.execute();

    }

    private void createRepeatedSchedules() throws RepatedScheduleCreationException {
        try {
            Timer timer = new Timer();
            timer.schedule(scheduler, DateUtils.getNextMonday(), TimeUnit.DAYS.toMillis(SCHEDULE_UPDATE_DURATION_DAYS));
        } catch (final ParseException ex) {
            // TODO: add logging
            throw new RepatedScheduleCreationException("Could not create repeated schedule for weekly shift scheduling");
        }
    }

    private void createSchedules() throws RepatedScheduleCreationException {
        createInitialSchedule();
        createRepeatedSchedules();
    }

    private void createInitialSchedule() {
        scheduler.createSchedule(INITIAL_SCHEDULE_DURATION_DAYS, new Date());
    }

}
