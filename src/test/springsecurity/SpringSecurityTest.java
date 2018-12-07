package springsecurity;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class SpringSecurityTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setMockMvc(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public  void whenLoginSuccess()throws Exception{
        //模拟请求执行
        mockMvc.perform(MockMvcRequestBuilders.get("/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//指定请求的类型
                .andExpect(MockMvcResultMatchers.status().isOk())//期望返回httpstatus=200
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));//
    }
}
