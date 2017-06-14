package com.huotu.controller;

import com.huotu.config.RootConfig;
import com.huotu.dao.UserDao;
import com.huotu.entity.Result;
import com.huotu.entity.User;
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

import java.util.List;

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

    @Autowired
    private UserDao userDao;

    private MockMvc mockMvc;

    @Before
    public void setMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    /**
     * 测试controller方法直接调用测试返回数据
     */
    @Test
    public void test1() {
        Result result = helloController.testPrint();
        System.out.println(result);
        System.out.println(result.getCode());
        System.out.println(result.getData());
    }

    /**
     * 测试controller方法请求返回视图(一般返回json数据测试，不返回视图测试)
     *
     * @throws Exception
     */
    @Test
    public void getView() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String str = (String) mvcResult.getModelAndView().getModel().get("hello");
        System.out.println(str);
    }

    /**
     * 测试controller方法请求返回数据
     *
     * @throws Exception
     */
    @Test
    public void getInfo() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/testPrint"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    /**
     * 测试保存数据
     */
    @Test
    public void save() {
        User user = new User();
        user.setUserId("2");
        user.setUserName("李四");
        user.setEmail("123456@qq.com");
        userDao.save(user);
    }

    /**
     * 测试查询所有数据
     */
    @Test
    public void findAll() {
        List<User> userList = userDao.findALL();
        for (User userInfo : userList) {
            System.out.println(userInfo.toString());
        }
    }
}
