package cn.bored.service.userupdate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 14:05
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BoredServiceProviderUserUpdateApplication.class)
@AutoConfigureMockMvc
public class UserTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getUserByToken()
    {
        try {
            System.out.println("result--->"+mvc.perform(MockMvcRequestBuilders.get("/user/getUserByToken").param("token", "token1")).andExpect(MockMvcResultMatchers.status().isOk()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
