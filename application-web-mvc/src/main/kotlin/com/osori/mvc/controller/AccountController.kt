package com.osori.mvc.controller

import com.osori.mvc.domain.Account
import com.osori.mvc.service.AccountService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController (private val accountService: AccountService) {


    @GetMapping("/account/{username}/{password}/{role}")
    fun insert(@ModelAttribute account: Account): Account {
        return accountService.createNew(account)
    }
}