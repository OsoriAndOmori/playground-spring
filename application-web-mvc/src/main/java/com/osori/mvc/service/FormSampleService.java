package com.osori.mvc.service;

import com.osori.mvc.custom.AccountContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FormSampleService {

    public void dashboard() {
        UserDetails account = AccountContext.getAccount();

        log.info("account : {}", account);
    }
}
