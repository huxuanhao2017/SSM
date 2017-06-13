package com.huotu.controller;

import com.huotu.config.RootConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by hxh on 2017-06-13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@WebAppConfiguration
public class HelloControllerTest {

        @Autowired
        private WebApplicationContext context;

        @Autowired
        private HelloController helloController;

        private MockMvc mockMvc;
        @Before
        public void setMockMvc() throws Exception{
            mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        }
        @Test
        public void test1(){
            String s = helloController.testPrint();
            System.out.println(s);
        }
        @Test
        public void test2() throws Exception {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            String str = (String) mvcResult.getModelAndView().getModel().get("hello");
            System.out.println(str);

        }
}
