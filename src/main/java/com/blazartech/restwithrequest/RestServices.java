/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.restwithrequest;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AAR1069
 */
@RestController
public class RestServices {

    private static final Logger logger = LoggerFactory.getLogger(RestServices.class);

    @GetMapping(path = "/name")
    public NameResponse getName(HttpServletRequest request) {
        logger.info("getting name");

        NameResponse nr = new NameResponse();
        nr.setName("Scott");
        nr.setUrl(request.getRequestURI());
        
        String greeting = request.getHeader("Greeting");
        if (greeting != null) {
            logger.info("greeting = " + greeting);
            nr.setGreeting(greeting);
        }

        return nr;
    }
}
