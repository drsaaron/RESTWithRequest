/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.restwithrequest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.is;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author AAR1069
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(RestServices.class)
public class RestServicesTest {
    
    private static final Logger logger = LoggerFactory.getLogger(RestServicesTest.class);
    
    @Autowired
    private MockMvc mockMvc;
    
    public RestServicesTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getName method, of class RestServices.
     */
    @Test
    public void testGetName_noGreeting() throws Exception {
        logger.info("getName_noGreeting");

        ResultActions result = mockMvc.perform(get("/name"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is("Scott")))
                .andExpect(jsonPath("url", is("/name")))
                .andExpect(jsonPath("greeting").value(IsNull.nullValue()));
    }
    
    @Test
    public void testGetName_withGreeting() throws Exception {
        logger.info("getName_withGreeting");

        ResultActions result = mockMvc.perform(get("/name").header("Greeting", "hola amigos"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is("Scott")))
                .andExpect(jsonPath("url", is("/name")))
                .andExpect(jsonPath("greeting", is("hola amigos")));
    }
}
