package com.osori.mvc.controller;

import com.osori.mvc.custom.AccountContext;
import com.osori.mvc.service.AccountService;
import com.osori.mvc.service.FormSampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class FormController {
    private final FormSampleService formSampleService;
    private final AccountService accountService;

    @GetMapping("/")
    public ModelAndView index(Principal principal) {
        ModelAndView mv = new ModelAndView("index");

        if (principal == null) {
            mv.addObject("message", "Hello Spring Security index");
        } else {
            mv.addObject("message", "Hello Spring Security index, " + principal.getName());
        }
        return mv;
    }

    @GetMapping("/info")
    public ModelAndView info() {
        return new ModelAndView("info")
                .addObject("message", "info");
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard(Principal principal) {
        AccountContext.setAccount(accountService.loadUserByUsername(principal.getName()));

        formSampleService.dashboard();
        return new ModelAndView("dashboard")
                .addObject("message", "Hello, " + principal.getName());
    }

    @GetMapping("/admin")
    public ModelAndView admin(Principal admin) {
        return new ModelAndView("admin")
                .addObject("message", "Hello Spring Security");
    }

}
