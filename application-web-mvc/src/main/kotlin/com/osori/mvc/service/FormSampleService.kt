package com.osori.mvc.service

import com.osori.mvc.custom.AccountContext
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
class FormSampleService {
    private val log = LoggerFactory.getLogger(javaClass)

    fun dashboard() {
        val account: UserDetails = AccountContext.getAccount()
        log.info("account : {}", account)
    }
}