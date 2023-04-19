package com.osori.mvc.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * securityFilterChain 을 테스트하는 것임.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void index_anonymous() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/").with(anonymous()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void index_user() throws Exception {
        // 이러한 유저가 이미 로그인을 한 상태다 라고 가정을 한거임. pass 는 안써도 상관없음.
        // 이미 인증이 되어있는 상태라 가정이라.
        mockMvc.perform(MockMvcRequestBuilders.get("/").with(user("sky").roles("USER")))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void admin_user_forbidden() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin").with(user("sky").roles("USER")))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void index_admin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin").with(user("admin").roles("ADMIN")))
                .andDo(print())
                .andExpect(status().isOk());
    }
}