
package com.astro.test.supportschedule;

import com.astro.test.supportscheduleclient.dto.Company;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author mithbose
 */
@WebService(serviceName = "SupportSchedulerService")
public class SupportScheduleService {

    Company company;

    public SupportScheduleService() {
        company = new Company();
    }
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getSupportSchedule")
    public String getSchedule(@WebParam(name = "name") String txt) {
        
        return "Hello " + txt + " !";
    }
}


// TODO: Learn more about javaDb and check its usage is possible?
// Reference: https://www.youtube.com/watch?v=wR-PuYqn1Jc
// TODO: leanr rest API coding from coursera.
