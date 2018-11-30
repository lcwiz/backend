package com.liuchang.backend;

import com.google.common.annotations.VisibleForTesting;
import io.swagger.annotations.Api;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)//使用springrunner运行测试用例
@SpringBootTest
public class LoginControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    /**
     * 测试方法执行前调用此方法
     */
    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void querySuccess()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

    @Test
    public void querySingleUser()throws Exception{
         mockMvc.perform(MockMvcRequestBuilders.get("user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                 .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("tom"));

    }

    @Test
    public void insertUser()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/adduser")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("userid","123")
                .param("username","liuchang")
                .param("gender","1")
                .param("passwd","123")
            )                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
