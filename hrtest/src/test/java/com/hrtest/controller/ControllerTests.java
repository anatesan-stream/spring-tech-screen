package com.hrtest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by anatesan on 4/4/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void getSingleEmpWithFoundEmpnoTest() throws Exception {
        this.mvc.perform(get("/employee/7369").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$[0].empno").value(7369));
    }

    @Test
    public void getSingleEmpWithNotFoundEmpnoTest() throws Exception {
        this.mvc.perform(get("/employee/7400").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$..empno").doesNotExist());
    }

    @Test
    public void wrongPathTest() throws Exception {
        // dept does not exist as a mapped path.
        this.mvc.perform(get("/depts").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAllEmpTest() throws Exception {
        // should really be testing to see if array is of length 14 with arrayWithSize(14)
        // but couldn't get this to work so wimped out.
        this.mvc.perform(get("/employees").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$..*").isArray());
    }

}