package com.osori.mvc.controller;

import com.osori.mvc.domain.Account;
import com.osori.mvc.repository.AccountRepository;
import com.osori.mvc.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/account/{username}/{password}/{role}")
    public Account insert(@ModelAttribute Account account) {
        return accountService.createNew(account);
    }
}
