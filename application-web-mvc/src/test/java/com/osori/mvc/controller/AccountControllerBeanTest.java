package com.osori.mvc.controller;

import com.osori.mvc.playground.springcore.policy.FixedDiscountPolicy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * securityFilterChain 을 테스트하는 것임.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountControllerBeanTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void test() throws Exception {
        AccountController accountController = applicationContext.getBean("accountController", AccountController.class);
        FixedDiscountPolicy accountService = applicationContext.getBean("fixedDiscountPolicy", FixedDiscountPolicy.class);
        System.out.println(accountController);
        System.out.println(accountService);
    }
}